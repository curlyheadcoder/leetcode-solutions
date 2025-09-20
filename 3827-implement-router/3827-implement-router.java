class Router {
    private int memoryLimit;
    private Deque<int[]> queue; // FIFO packets
    private Set<String> packetSet; // for duplicate detection
    private Map<Integer, List<Integer>> destTimestamps; // dest -> all timestamps
    private Map<Integer, Integer> startIdx; // dest -> index pointer of first valid timestamp

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.packetSet = new HashSet<>();
        this.destTimestamps = new HashMap<>();
        this.startIdx = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (packetSet.contains(key)) return false; // duplicate

        // evict oldest if full
        if (queue.size() == memoryLimit) {
            int[] oldest = queue.pollFirst();
            String oldKey = oldest[0] + "#" + oldest[1] + "#" + oldest[2];
            packetSet.remove(oldKey);

            // increment pointer for that destination
            startIdx.put(oldest[1], startIdx.get(oldest[1]) + 1);
        }

        queue.offerLast(new int[]{source, destination, timestamp});
        packetSet.add(key);

        destTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        startIdx.putIfAbsent(destination, 0);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[]{};
        int[] packet = queue.pollFirst();
        String key = packet[0] + "#" + packet[1] + "#" + packet[2];
        packetSet.remove(key);

        // increment pointer for that destination
        startIdx.put(packet[1], startIdx.get(packet[1]) + 1);
        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination)) return 0;
        List<Integer> list = destTimestamps.get(destination);
        int start = startIdx.getOrDefault(destination, 0);

        // if all timestamps for this destination are already forwarded/evicted
        if (start >= list.size()) return 0;

        int left = lowerBound(list, start, startTime);
        int right = upperBound(list, start, endTime);
        return right - left;
    }

    // lowerBound: first index >= target
    private int lowerBound(List<Integer> list, int from, int target) {
        int l = from, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    // upperBound: first index > target
    private int upperBound(List<Integer> list, int from, int target) {
        int l = from, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}