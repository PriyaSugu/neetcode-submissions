class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > temperatures[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }

        return res;
    }
}
