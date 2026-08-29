class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            for(char ch: str.toCharArray()){
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            anagramMap.computeIfAbsent(key, k -> new ArrayList()).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
