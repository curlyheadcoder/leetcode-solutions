class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diagMap = new HashMap<>();
        // Step 1: Collect all diagonals into map with key = i - j
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                diagMap.computeIfAbsent(i - j, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }
        // Step 2: Sort each diagonal list
        for(int key : diagMap.keySet()){
            List<Integer> list = diagMap.get(key);
            if(key < 0){
                list.sort(Collections.reverseOrder());  // bottom-left (descending)
            }else{
                Collections.sort(list);      // top-right (ascending)
            }
        }
        // Step 3: Refill the grid by popping from each diagonal 
        // (pop from end for efficiency)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                List<Integer> list = diagMap.get(i-j);
                grid[i][j] = list.remove(list.size() - 1);
            }
        }
        return grid;
    }
}