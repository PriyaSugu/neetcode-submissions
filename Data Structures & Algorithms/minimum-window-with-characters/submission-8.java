class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            required.put(ch, required.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0;
        int have = 0, need = required.size();
        int start = 0, end = Integer.MAX_VALUE;

        while (r < s.length()) {
            char rchar = s.charAt(r);
            window.put(rchar, window.getOrDefault(rchar, 0) + 1);
            if (required.containsKey(rchar) && window.get(rchar).equals(required.get(rchar))) {
                have++;
            }

            while (have == need) {
                int w = r - l + 1;
                if (w < end) {
                    start = l;
                    end = r - l + 1;
                }
                char lchar = s.charAt(l);
                window.put(lchar, window.get(lchar) - 1);
                if (required.containsKey(lchar) && window.get(lchar) < required.get(lchar)) {
                    have--;
                }
                l++;
            }
            r++;
        }

        return end == Integer.MAX_VALUE ? "" : s.substring(start, start + end);
    }
}
