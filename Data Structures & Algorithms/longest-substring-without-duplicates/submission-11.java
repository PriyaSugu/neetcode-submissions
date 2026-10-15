class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            char curr = s.charAt(right);
            while (set.contains(curr)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }
}
