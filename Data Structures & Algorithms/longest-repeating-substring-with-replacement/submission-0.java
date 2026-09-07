class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> charSet = new HashSet<>();
        for(char ch : s.toCharArray()){
            charSet.add(ch);
        }
        int longest = 0;

        for(char c : charSet){
            int count = 0, left = 0;
            for(int right = 0; right < s.length(); right++){
                if(s.charAt(right) == c){
                    count++;
                }
                while((right - left + 1) - count > k){
                    if(s.charAt(left) == c){
                        count--;
                    }
                    left++;
                }
                longest = Math.max(longest, right - left + 1);
            }
        }

        return longest;
        
    }
}
