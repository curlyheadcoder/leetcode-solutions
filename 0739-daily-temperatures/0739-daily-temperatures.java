class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] res = new int [n];
        Stack<Integer> st = new Stack<>();   // store index
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                res[i] = st.peek() - i; 
            }else{
                res[i] = 0;
            }
            st.push(i);
        }
        return res;
    }
}