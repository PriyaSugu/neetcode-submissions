class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i]))
                return true;
            map.put(nums[i], map.get(nums[i]++));
        }
        return false;
    }
}
