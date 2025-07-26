class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        removeValidParentheses(s, stack);

        // If no invalid parentheses, full string is valid
        if (stack.isEmpty()) {
            return s.length();
        }

        // Collect invalid indices into a list
        List<Integer> invalidIndices = new ArrayList<>();
        while (!stack.isEmpty()) {
            invalidIndices.add(stack.pop());
        }
        // Sort invalid indices ascending (stack popped in descending order)
        Collections.sort(invalidIndices);

        // Add sentinel boundaries
        invalidIndices.add(0, -1);
        invalidIndices.add(s.length());

        int maxLen = 0;
        for (int i = 1; i < invalidIndices.size(); i++) {
            int gap = invalidIndices.get(i) - invalidIndices.get(i - 1) - 1;
            maxLen = Math.max(maxLen, gap);
        }
        return maxLen;
    }

    private void removeValidParentheses(String s, Stack<Integer> stack) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else { // ch == ')'
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop(); // matched, remove '(' index
                } else {
                    stack.push(i); // unmatched ')'
                }
            }
        }
    }
}
