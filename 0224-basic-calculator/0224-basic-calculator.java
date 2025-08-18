class Solution {
    public int calculate(String s) {
        int n = s.length();
        int res = 0, num = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        boolean mayBeUnary = true; // flag to check if unary operator can appear

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') continue;
            
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                mayBeUnary = false; // number means no unary next
            } else {
                // Add previous number if any
                res += sign * num;
                num = 0;

                if (ch == '+') {
                    sign = stack.peek() * 1;
                    mayBeUnary = true;
                } else if (ch == '-') {
                    sign = stack.peek() * -1;
                    mayBeUnary = true;
                } else if (ch == '(') {
                    // Push the current sign context onto stack
                    stack.push(sign);
                    mayBeUnary = true;
                } else if (ch == ')') {
                    stack.pop();
                    mayBeUnary = false;
                }
            }
        }
        res += sign * num;
        return res;
    }
}
