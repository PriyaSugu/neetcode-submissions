class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){
            return s.length();
        }
        int maxLength = 0;
        Set<Character> uniqueChars = new HashSet<>();
        for(int left = 0, right = 0; right < s.length(); right++){
            while(uniqueChars.contains(s.charAt(right))){
                uniqueChars.remove(s.charAt(left));
                left++;
            }
            uniqueChars.add(s.charAt(right));
            maxLength = Math.max(maxLength, uniqueChars.size());
        }
        return maxLength;
    }
}
