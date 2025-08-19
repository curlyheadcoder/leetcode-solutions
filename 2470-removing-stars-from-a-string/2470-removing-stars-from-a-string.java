class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(st.size() != 0) st.pop();  // remove closest character to left
            }else st.push(ch);   
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() != 0) sb.append(st.pop());
        return sb.reverse().toString();
    }
}