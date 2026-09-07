class Solution {
    public int maxArea(int[] heights) {

        int max = 0, currArea = 0;
        int l = 0, r = heights.length - 1;
        while(l < r){
            
            if(heights[l] < heights[r]){
                currArea = heights[l] * (r - l);
                l++;
            }else{
                currArea = heights[r] * (r - l);
                r--;
            }
            max = Math.max(max, currArea);
        }

        return max;
        
    }
}
