class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxf = 0, res = 0;
        for(int l = 0, r = 0; r < s.length(); r++){
            char curr = s.charAt(r);
            count[curr - 'A']++;

            maxf = Math.max(maxf, count[curr-'A']);

            while((r-l+1) - maxf > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r-l+1);

        }
        return res;
    }
}
