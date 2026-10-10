class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        while(left < right){
            int area = 0;
            if(heights[left] < heights[right]){
                area = (right-left) * heights[left];
                left++;
            }else{
                area = (right-left) * heights[right];
                right--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
