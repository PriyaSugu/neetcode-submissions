class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0, maxF = 0, res = 0;
        for(int r = 0; r < s.length(); r++){
            char curr = s.charAt(r);
            count[curr - 'A']++;
            maxF = Math.max(maxF, count[curr - 'A']);
            while((r - l + 1) - maxF > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, (r-l+1));
        }
        return res;
    }
}
