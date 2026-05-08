class Solution {

    private boolean [] isPrime;

    private void buildSieve(int maxEl){
        isPrime = new boolean [maxEl + 1];
        Arrays.fill(isPrime, true);

        if(maxEl >= 0) isPrime[0] = false;
        if(maxEl >= 1) isPrime[1] = false;

        for(int num = 2; num * num <= maxEl; num++){
            if(isPrime[num]){
                for(int multiple = num * num; multiple <= maxEl; multiple += num){
                    isPrime[multiple] = false;
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxEl = 0;
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            maxEl = Math.max(maxEl, nums[i]);
        }
        buildSieve(maxEl);
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean [n];
        q.offer(0);
        visited[0] = true;
        HashSet<Integer> seen = new HashSet<>();
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int i = q.poll();
                if(i == n-1){
                    return steps;
                }
                // i-1
                if(i-1 >= 0 && !visited[i-1]){
                    q.offer(i-1);
                    visited[i-1] = true;
                }
                // i+1
                if(i+1 < n && !visited[i+1]){
                    q.offer(i+1);
                    visited[i+1] = true;
                }
                // skip if not prime or already processed 
                if(!isPrime[nums[i]] || seen.contains(nums[i])){
                    continue;
                }
                // visit all multiples
                for(int multiple = nums[i]; multiple <= maxEl; multiple += nums[i]){
                    if(!map.containsKey(multiple)){
                        continue;
                    }
                    for(int j : map.get(multiple)){
                        if(!visited[j]){
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }
                seen.add(nums[i]);

            }
            steps++;
        }
        return -1;
    }
}