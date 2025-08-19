class Solution {
    public String decodeString(String s) {
        Stack<Integer> val = new Stack<>();
        Stack<StringBuilder> op = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + ch - '0';
            }else if(ch == '['){
                val.push(k);
                op.push(curr);
                curr = new StringBuilder();
                k = 0;
            }else if(ch == ']'){
                StringBuilder prev = op.pop();
                int count = val.pop();
                for(int i = 0; i < count; i++){
                    prev.append(curr);
                }
                curr = prev;
            }else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}