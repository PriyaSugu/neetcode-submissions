class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 1){
            return 0;
        }

        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int longest = 0;

        while(right < s.length()){
            char curr = s.charAt(right);
            while(set.contains(curr)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            longest = Math.max(longest, set.size());
            right++;
        }
        return longest;
    }
}
