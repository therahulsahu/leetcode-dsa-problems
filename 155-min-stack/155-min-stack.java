class MinStack {
    
    Deque<Integer> stack;
    Deque<Integer> minSt;

    public MinStack() {
        stack = new ArrayDeque<>();
        minSt = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minSt.isEmpty() || minSt.peek() >= val) {
            minSt.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) {
            return ;
        }
        int popped = stack.pop();
        if(popped == minSt.peek()) {
            minSt.pop();
        }
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
        if(minSt.isEmpty()) {
            return -1;
        }
        return minSt.peek();
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