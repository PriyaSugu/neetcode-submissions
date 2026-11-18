class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(String token: tokens){
            if(token.equals("+")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1 + op2);
            }else if(token.equals("-")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1 - op2);
            }else if(token.equals("*")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1 * op2);
            }else if(token.equals("/")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1 / op2);
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
