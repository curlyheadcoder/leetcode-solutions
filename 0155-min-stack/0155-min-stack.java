class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        long x = val; // store as long internally
        if (st.isEmpty()) {
            st.push(x);
            min = x;
        } else if (x >= min) {
            st.push(x);
        } else {
            // Push encoded value
            st.push(2 * x - min);
            min = x;
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        long top = st.peek();
        if (top >= min) {
            st.pop();
        } else {
            // Restore previous min
            long oldMin = 2 * min - top;
            st.pop();
            min = oldMin;
        }
    }

    public int top() {
        if (st.isEmpty()) return -1;

        long top = st.peek();
        if (top >= min) {
            return (int) top;
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        if (st.isEmpty()) return -1;
        return (int) min;
    }
}