class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){
            return s.length();
        }
        int l = 0;
        Set<Character> set = new HashSet<>();
        int longest = 0;
        for(int r = 0; r < s.length(); r++){    
            char ch = s.charAt(r);
            while(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            longest = Math.max(longest, set.size());
        }
        return longest;
    }
}
