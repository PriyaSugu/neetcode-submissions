class Solution {
    public int maxArea(int[] heights) {

        int left = 0, right = heights.length - 1;

        int max = 0;

        while(left < right){
            int height = Math.min(heights[left], heights[right]);
            int width = right  - left;
            max = Math.max(max, height * width);
            if(height == heights[left]){
                left++;
            }else{
                right--;
            }
        }

        return max;
        
    }
}
