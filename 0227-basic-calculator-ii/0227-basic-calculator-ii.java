class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        int operator = '+';
        for(int idx = 0; idx < s.length(); idx++){
            char ch = s.charAt(idx);
            if(Character.isDigit(ch)){
                currNum = (currNum * 10) + (ch - '0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || (idx == s.length() -1)){
                if(operator == '+'){
                    st.push(currNum);
                }
                else if(operator == '-'){
                    st.push(-1 * currNum);
                }
                else if(operator == '*'){
                    st.push(currNum * st.pop());
                }
                else if(operator == '/'){
                    st.push(st.pop() / currNum);
                }
                currNum = 0;
                operator = ch;
            }
        }
        int sum = 0;
        while(st.size () != 0){
            sum += st.pop();
        }
        return sum;
    }
}