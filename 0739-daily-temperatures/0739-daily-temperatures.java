class Solution{
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int[] stack = new int[n]; // manual stack
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && temperatures[i] >= temperatures[stack[top]]) {
                top--; // pop
            }
            res[i] = (top == -1) ? 0 : (stack[top] - i);
            stack[++top] = i; // push
        }
        return res;
    }
}
