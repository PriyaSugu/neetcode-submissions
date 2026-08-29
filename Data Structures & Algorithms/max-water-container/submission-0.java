class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxCapacity = 0;
        while(left < right){
            int length = right - left;
            int area = 0;
            if(heights[left] <= heights[right]){
                area = heights[left] * length;
                left++;
            }else{
                area = heights[right] * length;
                right--;
            }
            maxCapacity = Math.max(maxCapacity, area);
        }
        return maxCapacity;
        
    }
}
