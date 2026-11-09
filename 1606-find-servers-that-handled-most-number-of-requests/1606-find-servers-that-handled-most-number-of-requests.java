
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        // Initially, all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // {finishTime, serverIndex}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            int currentTime = arrival[i];

            // Release servers whose tasks are completed
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= currentTime) {

                int[] server = busy.poll();
                available.add(server[1]);
            }

            // No server available
            if (available.isEmpty()) {
                continue;
            }

            // Preferred server index
            int preferred = i % k;

            // Find smallest available server >= preferred
            Integer server = available.ceiling(preferred);

            // Wrap around if no such server exists
            if (server == null) {
                server = available.first();
            }

            // Assign request
            available.remove(server);

            count[server]++;

            // Mark server busy
            busy.offer(new int[]{
                currentTime + load[i],
                server
            });
        }

        // Find maximum number of requests handled
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Collect all busiest servers
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
