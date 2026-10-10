class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        while(left < right){
            int area = 0;
            int width = right - left;
            if(heights[left] < heights[right]){
                area = width * heights[left];
                left++;
            }else{
                area = width * heights[right];
                right--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
