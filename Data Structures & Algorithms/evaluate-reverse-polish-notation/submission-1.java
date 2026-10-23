class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    stack.push(op1 + op2);
                } break;
                case "-": {
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    stack.push(op1 - op2);
                } break;
                case "*": {
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    stack.push(op1 * op2);
                } break;
                case "/": {
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    stack.push(op1 / op2);
                } break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
