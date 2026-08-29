class Solution {
    public int lengthOfLongestSubstring(String s) {
         if(s.length() < 2){
            return s.length();
         }
         int i = 0, j = 1;
         int maxLen = 0;
         Set<Character> set = new HashSet<>();
         set.add(s.charAt(i));
         while(j < s.length()){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }else{
                set.add(s.charAt(j++));
            }
            maxLen = Math.max(maxLen, set.size());
         }
         return maxLen;
    }
}
