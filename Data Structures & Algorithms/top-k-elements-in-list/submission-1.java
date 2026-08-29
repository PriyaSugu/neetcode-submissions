class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key: map.keySet()){
            res.add(new int[]{map.get(key),key});
        }
        res.sort((a,b) -> (b[0] - a[0]));
        int[] resArr = new int[k];
        for(int i = 0; i < k; i++){
            resArr[i] = res.get(i)[1];
        }
        return resArr;
    }
}
