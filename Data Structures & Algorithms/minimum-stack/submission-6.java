class MinStack {

    Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(!st.isEmpty() && st.peek()[1] < val){
            st.push(new int[]{val,st.peek()[1]});
        }else{
            st.push(new int[]{val,val});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return !st.isEmpty() ? st.peek()[0] : null;
    }
    
    public int getMin() {
        return !st.isEmpty() ? st.peek()[1] : null;
    }
}
