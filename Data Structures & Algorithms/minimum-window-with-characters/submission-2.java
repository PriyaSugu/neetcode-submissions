class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen) {
            return "";
        }

        Map<Character, Integer> required = new HashMap<>();

        Map<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            required.put(ch, required.getOrDefault(ch, 0) + 1);
        }

        int start = 0, resLen = Integer.MAX_VALUE;
        int have = 0, need = required.size();

        for (int left = 0, right = 0; right < sLen; right++) {
            char curr = s.charAt(right);
            window.put(curr, window.getOrDefault(curr, 0) + 1);
            if (required.containsKey(curr) && required.get(curr).equals(window.get(curr))) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < resLen) {
                    start = left;
                    resLen = right - left + 1;
                }

                char lchar = s.charAt(left);
                window.put(lchar, window.get(lchar) - 1);
                if (required.containsKey(lchar) && window.get(lchar) < required.get(lchar)) {
                    have--;
                }
                left++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
    }
}
