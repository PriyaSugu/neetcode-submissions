class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int s1len = s1.length();
        int[] s1freq = new int[26];

        for(char ch: s1.toCharArray()){
             s1freq[ch - 'a']++;
        }

        int left = 0;
        int[] window = new int[26];
        for(int right = 0; right < s2.length(); right++){
            boolean found = true;
            window[s2.charAt(right) - 'a']++;
            
            if(right - left + 1 > s1len){
                window[s2.charAt(left) - 'a']--;
                left++;
            }
            if(right - left + 1 == s1len){
                for(int i = 0; i < 26; i++){
                    if(window[i] != s1freq[i]){
                        found = false;
                    }        
                }
                if(found){
                    return true;
                }
            }
            
        }

        return false;

        
    }
}
