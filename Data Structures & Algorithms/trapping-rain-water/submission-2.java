class Solution {
    public int trap(int[] heights) {
        int l = 0, r = heights.length - 1;
        int leftMax = heights[l], rightMax = heights[r];
        int water = 0;
        while(l < r){
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                water += (leftMax - heights[l]);
            }else{
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                water += (rightMax - heights[r]);
            }
        }
        return water;
    }
}
