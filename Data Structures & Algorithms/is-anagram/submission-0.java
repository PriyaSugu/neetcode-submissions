class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] s_sorted = s.toCharArray();
        char[] t_sorted = t.toCharArray();
        Arrays.sort(s_sorted);
        Arrays.sort(t_sorted);
        return Arrays.equals(s_sorted,t_sorted);
    }
}
