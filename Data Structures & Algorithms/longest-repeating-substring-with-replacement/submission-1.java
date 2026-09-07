class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int longest = 0;
        int left = 0, maxFreq = 0;
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            longest = Math.max(right - left + 1, longest);

        }

        return longest;
        
    }
}
