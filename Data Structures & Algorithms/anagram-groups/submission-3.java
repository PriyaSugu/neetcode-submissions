class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] freq = new char[26];
            for(char ch: str.toCharArray()){
                freq[ch - 'a']++;
            }
            
            map.computeIfAbsent(new String(freq), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
