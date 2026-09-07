class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int water = 0;
        int l = 0, r = height.length - 1;

        while(l < r){
            
            
            if(height[l] < height[r]){
                leftMax = Math.max(height[l], leftMax);
                water += leftMax - height[l];
                l++;
            }else{
                rightMax = Math.max(height[r], rightMax);
                water += rightMax - height[r];
                r--;
            }
            
        }
        return water;
    }
}
