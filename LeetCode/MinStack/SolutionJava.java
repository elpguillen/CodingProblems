class MinStack {

    Stack<Integer> stackValues;
    Stack<Integer> minValues;

    public MinStack() {
        stackValues = new Stack<Integer>();
        minValues = new Stack<Integer>();
    }
    
    public void push(int val) {

        if (!minValues.empty()) {
            int minValue = minValues.peek();

            if (minValue > val) {
                minValues.push(val);
            } else {
                minValues.push(minValue);
            }
        } else {
            minValues.push(val);
        }

        stackValues.push(val);
    }
    
    public void pop() {
        stackValues.pop();
        minValues.pop();
    }
    
    public int top() {
        return stackValues.peek();
    }
    
    public int getMin() {
        return minValues.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */