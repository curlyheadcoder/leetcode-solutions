class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = basket1.length;
        for(int b : basket1) count.put(b, count.getOrDefault(b,0)+1);
        for(int b : basket2) count.put(b, count.getOrDefault(b,0)-1);

        List<Integer> extra = new ArrayList<>();
        int minCost = Integer.MAX_VALUE;
        // Validate feasibility and collect extras
        for(Map.Entry<Integer, Integer> e : count.entrySet()){
            int fruit = e.getKey();
            int diff = e.getValue();
            minCost = Math.min(minCost, fruit);

            if(diff % 2 != 0) return -1;

            for(int i = 0; i < Math.abs(diff)/2; i++){
                extra.add(fruit);
            }
        }
        Collections.sort(extra);
        int m = extra.size()/2;
        long cost = 0;

        for(int i = 0; i < m; i++){
            int directSwap = extra.get(i);
            cost += Math.min(directSwap, 2 * minCost);
        }
        return cost;
    }
}