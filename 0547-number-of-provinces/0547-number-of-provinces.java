class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean [] visited = new boolean [n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int [][] isConnected, boolean [] visited, int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int city = stack.pop();
            if (!visited[city]) {
                visited[city] = true;
                for (int j = 0; j < isConnected.length; j++) {
                    if (isConnected[city][j] == 1 && !visited[j]) {
                        stack.push(j);
                    }
                }
            }
        }
    }
}