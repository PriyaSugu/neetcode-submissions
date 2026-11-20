class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int m = l + (r-l)/2;
            if(nums[m] < nums[r]){
                r = m;
            }else{
                l = m + 1;
            }
        }
        int pivot = l;
        if(pivot == 0){
            l = 0;
            r = nums.length - 1;
        }else if (nums[0] <= target){
            l = 0;
            r = pivot - 1;
        }else{
            l = pivot;
            r = nums.length - 1;
        }

        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] == target){
                return m;
            }else if(nums[m] < target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return -1;
    }
}
