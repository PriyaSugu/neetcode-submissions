class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char ch: t.toCharArray()){
            required.put(ch, required.getOrDefault(ch,0)+1);
        }

        int have = 0, need = required.size();

        int l = 0, r = 0;

        int start = 0;
        int end = Integer.MAX_VALUE;

        while(r < s.length()){
            char curr = s.charAt(r);
            window.put(curr, window.getOrDefault(curr, 0) + 1);
            if(required.containsKey(curr) && window.get(curr).equals(required.get(curr))){
                have++;
            }
            while(need == have){
                if((r - l + 1) < end){
                    start = l;
                    end = r - l + 1;
                }
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if(required.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < required.get(s.charAt(l))){
                    have--;
                }
                l++;
            }
            r++;
        }
        return end == Integer.MAX_VALUE? "" : s.substring(start, start + end);
        
    }
}
