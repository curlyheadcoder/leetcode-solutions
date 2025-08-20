class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> val = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int v2 = val.pop();
                int v1 = val.pop();
            
                switch(token){
                    case "+":
                        val.push(v1+v2);
                        break;
                    case "-":
                        val.push(v1-v2);
                        break;
                    case "*":
                        val.push(v1*v2);
                        break;
                    case "/":
                        val.push(v1/v2);
                        break;
                }
        }else {
            val.push(Integer.parseInt(token));
        }
     
        }
       return val.peek();
    }
}