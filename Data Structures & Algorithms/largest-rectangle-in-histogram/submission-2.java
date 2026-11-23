class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] >= heights[i]){
                int[] top = stack.pop();
                maxArea = Math.max(maxArea, top[1] * (i - top[0]));
                start = top[0];
            }
            stack.push(new int[]{start, heights[i]});
        }
        int idx = heights.length;
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, top[1] * (idx - top[0]));
        }
        return maxArea;
    }
}
