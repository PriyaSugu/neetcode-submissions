class Solution {
    public int maxArea(int[] heights) {

        int max = 0, currArea = 0, width = 0;
        int l = 0, r = heights.length - 1;
        while(l < r){
            width = r - l;
            if(heights[l] < heights[r]){
                currArea = heights[l] * width;
                l++;
            }else{
                currArea = heights[r] * width;
                r--;
            }
            max = Math.max(max, currArea);
        }

        return max;
        
    }
}
