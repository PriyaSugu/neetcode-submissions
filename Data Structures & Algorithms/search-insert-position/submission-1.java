class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if(target > nums[right]){
            return right+1;
        }
        int res = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
                res = mid;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}