class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        int longest = 0;

        for(int num: numSet){
            
            if(!numSet.contains(num - 1)){
                int len = 1;
                while(numSet.contains(num+len)){
                    len++;
                }
                longest = Math.max(len, longest);
            }

        }

        return longest;
    }
}
