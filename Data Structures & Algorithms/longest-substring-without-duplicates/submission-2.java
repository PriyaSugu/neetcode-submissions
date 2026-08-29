class Solution {
    public int lengthOfLongestSubstring(String s) {
         if(s.length() < 2){
            return s.length();
         }
         int i = 0, j = 0;
         int maxLen = 0;
         Set<Character> set = new HashSet<>();
         while(j < s.length()){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j++));
            maxLen = Math.max(maxLen, set.size());
         }
         return maxLen;
    }
}
