class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> val = new Stack<>();
        String operators = "+-*/";
        for(String token : tokens){
            if(operators.indexOf(token) != -1){
                int res = 0;
                int v2 = val.pop();
                int v1 = val.pop();
                if(token.equals("+")){
                    res = v1+v2;
                }else if(token.equals("-")){
                    res = v1 - v2;
                }else if(token.equals("*")){
                    res = v1 * v2;
                }else if(token.equals("/")){
                    res = v1 / v2;
                }
                val.push(res);
            }else{
                val.push(Integer.parseInt(token));
            }
        }
        return val.peek();
    }
}