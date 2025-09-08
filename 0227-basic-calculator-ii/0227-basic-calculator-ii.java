class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        int operator = '+';
        for(int idx = 0; idx < s.length(); idx++){
            char ch = s.charAt(idx);
            if(Character.isDigit(ch)){
                num = (num * 10) + (ch - '0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || (idx == s.length() -1)){
                if(operator == '+'){
                    st.push(num);
                }
                else if(operator == '-'){
                    st.push(-1 * num);
                }
                else if(operator == '*'){
                    st.push(num * st.pop());
                }
                else if(operator == '/'){
                    st.push(st.pop() / num);
                }
                num = 0;
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