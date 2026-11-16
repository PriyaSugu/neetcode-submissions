class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int num: nums){
            set.add(num);
        }

        for(int num: nums){
            if(!set.contains(num - 1)){
                int count = 1;
                while(set.contains(count + num)){
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
