class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            stack.push(num);
            // While top two elements of stack are non-coprime, merge them into their LCM
            while (stack.size() > 1) {
                int top = stack.pop();
                int nextTop = stack.pop();
                int gcd = gcd(top, nextTop);
                if (gcd == 1) {
                    // If coprime, push back in original order and break
                    stack.push(nextTop);
                    stack.push(top);
                    break;
                }
                // If non-coprime, push back their LCM and continue checking
                int lcm = nextTop / gcd * top;
                stack.push(lcm);
            }
        }

        return new ArrayList<>(stack);
    }

    // Helper method to find gcd using Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
