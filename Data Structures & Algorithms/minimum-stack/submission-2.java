class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        if( !stack.isEmpty()){
            if(!min.isEmpty() && min.peek() >= stack.peek()){
                min.pop();
            }
            stack.pop();
        }
    }
    
    public int top() {
        return !stack.isEmpty()? stack.peek() : null;
    }
    
    public int getMin() {
        return !min.isEmpty()? min.peek() : null;
    }
}
