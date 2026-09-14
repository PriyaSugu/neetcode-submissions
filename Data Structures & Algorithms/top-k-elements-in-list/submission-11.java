class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length + 1];
        for(int i = 1; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i = freq.length - 1; i >= 0 && idx < k; i--){
            for(int num: freq[i]){
                res[idx++] = num;
                if(idx == k){
                    return res;
                }
            }
        }
        return res;
    }
}
