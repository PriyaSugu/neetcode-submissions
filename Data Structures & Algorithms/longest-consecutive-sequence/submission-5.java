class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int num: nums){
            set.add(num);
        }

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                int count = 1;
                while(set.contains(count + nums[i])){
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
