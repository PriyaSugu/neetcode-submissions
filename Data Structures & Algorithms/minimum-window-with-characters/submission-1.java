class Solution {
    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();

        if (tLen > sLen) {
            return "";
        }

        Map<Character, Integer> freqT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        }

        int need = freqT.size();
        int have = 0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for (int l = 0, r = 0; r < sLen; r++) {
            char curr = s.charAt(r);
            window.put(curr, window.getOrDefault(curr, 0) + 1);
            if (freqT.containsKey(curr) && freqT.get(curr).equals(window.get(curr))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }
                char lchar = s.charAt(l);
                window.put(lchar, window.get(lchar) - 1);
                if (freqT.containsKey(lchar) && window.get(lchar) < freqT.get(lchar) ) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
