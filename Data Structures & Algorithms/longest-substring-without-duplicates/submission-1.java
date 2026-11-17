class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int longest = 0;
        while(r < s.length()){
            char curr = s.charAt(r);
            while(set.contains(curr)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(curr);
            longest = Math.max(longest, set.size());
            r++;
        }
        return longest;
    }
}
