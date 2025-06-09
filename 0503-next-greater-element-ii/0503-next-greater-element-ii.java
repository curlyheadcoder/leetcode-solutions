class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] res = new int [n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res, -1);
        // Traverse array twice (Circular)
        for(int i = 2*n -1; i >= 0; i--){
            int num = nums[i % n];
            // Maintain decreasing stack
            while(!st.isEmpty() && st.peek() <= num){
                st.pop();
            }
            // Fill the result only for the first pass (i < n)
            if(i < n){
                res[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(num);
        }
        return res;
    }
}