class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int idx = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - idx));
                start = idx;
            }
            stack.push(new int[] {start, heights[i]});
        }

        for(int[] pair : stack){
            maxArea = Math.max(maxArea, pair[1] * (heights.length - pair[0]));
        }

        return maxArea;
    }
}
