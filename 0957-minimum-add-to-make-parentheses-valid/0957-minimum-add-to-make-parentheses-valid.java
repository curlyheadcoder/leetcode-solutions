class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;    // st.push(ch);
            }else{
                // if(st.isEmpty() || st.peek() == ')')
                if(open <= 0){
                    close++;   // st.push(ch);
                }else{
                    open--;   // st.pop()
                }
            }
        }
        int res = open + close;
        return res;
    }
}