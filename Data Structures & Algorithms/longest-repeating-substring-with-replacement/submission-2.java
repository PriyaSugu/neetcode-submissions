class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0, r = 0;
        int maxF = 0;
        int longest = 0;

        while(r < s.length()){
            int idx = s.charAt(r) - 'A';
            count[idx]++;
            maxF = Math.max(maxF, count[idx]);
            while((r-l+1) - maxF > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            longest = Math.max(longest, (r-l+1));
            r++;
        }
        return longest;
    }
}
