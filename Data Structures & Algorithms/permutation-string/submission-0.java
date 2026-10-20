class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();

        if(s1len > s2len){
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        for(int i = 0; i < s1len; i++){
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(s1count[i] == s2count[i]){
                matches++;
            }
        }
        

        for(int l = 0, r = s1len; r < s2len; l++, r++){
            if(matches == 26){
                return true;
            }

            int idx = s2.charAt(r) - 'a';
            s2count[idx]++;
            if(s1count[idx] == s2count[idx]){
                matches++;
            }else if(s1count[idx] + 1 == s2count[idx]){
                matches--;
            }
            
            idx = s2.charAt(l) - 'a';
            s2count[idx]--;
            if(s1count[idx] == s2count[idx]){
                matches++;
            }else if(s1count[idx] - 1 == s2count[idx]){
                matches--;
            }
        }
        return matches == 26;
    }
}
