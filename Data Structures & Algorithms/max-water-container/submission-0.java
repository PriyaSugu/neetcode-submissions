class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int max = 0;
        int minHeight = Integer.MAX_VALUE;
        while(left < right){
            minHeight = Math.min(heights[left], heights[right]);
            max = Math.max(max, (right - left) * minHeight);
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return max;
    }
}
