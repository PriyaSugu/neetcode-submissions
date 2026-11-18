class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m > n){
            return false;
        }

        int[] s1freq = new int[26];
        int[] s2freq = new int[26];
        for(int i = 0; i < m; i++){
            s1freq[s1.charAt(i) - 'a']++;
            s2freq[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i = 0; i < 26;i++){
            if(s1freq[i] == s2freq[i]){
                matches++;
            }
        }
        for(int l = 0, r = m; r < n; l++,r++){
            if(matches == 26){
                return true;
            }

            int idx = s2.charAt(r) - 'a';
            s2freq[idx]++;
            if(s1freq[idx] == s2freq[idx]){
                matches++;
            }else if(s1freq[idx] + 1 == s2freq[idx]){
                matches--;
            }

            idx = s2.charAt(l) - 'a';
            s2freq[idx]--;
            if(s1freq[idx] == s2freq[idx]){
                matches++;
            }else if(s1freq[idx] - 1 == s2freq[idx]){
                matches--;
            }
        }
        return matches == 26;
    }
}
