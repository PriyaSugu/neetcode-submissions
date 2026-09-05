class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int longest = 0;
        for(int num: nums){
            numSet.add(num);
        }
        for(int num: numSet){
            int length = 1;
            if(!numSet.contains(num-1)){
                
                while(numSet.contains(num+length)){
                    length++;
                }
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
