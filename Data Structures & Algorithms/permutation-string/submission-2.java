class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int s1len = s1.length();
        int[] s1freq = new int[26];
        int unique = 0;

        for(char ch: s1.toCharArray()){
            if(s1freq[ch - 'a'] == 0){
                unique++;
            }
             s1freq[ch - 'a']++;
        }

        int left = 0;
        int[] window = new int[26];
        int matches = 0;
        for(int right = 0; right < s2.length(); right++){
            
            window[s2.charAt(right) - 'a']++;
            if(window[s2.charAt(right) - 'a'] == s1freq[s2.charAt(right) - 'a']){
                matches++;
            }
            
            if(right - left + 1 > s1len){
                if(window[s2.charAt(left) - 'a'] == s1freq[s2.charAt(left) - 'a']){
                    matches--;
                }
                window[s2.charAt(left) - 'a']--;
                left++;
            }
            if(right - left + 1 == s1len){
                if(matches == unique){
                    return true;
                }
            }
            
        }

        return false;

        
    }
}
