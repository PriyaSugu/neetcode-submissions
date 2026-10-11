class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Set<String> operators = new HashSet<>(List.of("+", "-", "*", "/"));

        for (String token : tokens) {
            if (operators.contains(token)) {
                int right = stack.pop();
                int left = stack.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = left + right;
                        break;
                    case "-":
                        res = left - right;
                        break;
                    case "*":
                        res = left * right;
                        break;
                    case "/":
                        res = left / right;
                        break;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
