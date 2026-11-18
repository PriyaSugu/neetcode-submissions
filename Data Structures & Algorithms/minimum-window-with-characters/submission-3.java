class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        if(slen < tlen){
            return "";
        }

        Map<Character, Integer> req = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();

        for(char ch: t.toCharArray()){
            req.put(ch, req.getOrDefault(ch, 0) + 1);
        }

        int start = 0, resLen = Integer.MAX_VALUE;
        int have = 0, need = req.size();

        for(int l = 0, r = 0; r < slen; r++){
            char curr = s.charAt(r);
            win.put(curr, win.getOrDefault(curr, 0) + 1);
            if(req.containsKey(curr) && req.get(curr).equals(win.get(curr))){
                have++;
            }

            while(have == need){
                if(r - l + 1 < resLen){
                    start = l;
                    resLen = r - l + 1;
                }
                char lchar = s.charAt(l);
                win.put(lchar, win.get(lchar) - 1);
                if(req.containsKey(lchar) && req.get(lchar) > win.get(lchar)){
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start+resLen);

    }
}
