class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for(int[] entry : minHeap){
            res[idx++] = entry[1];
        }

        return res;
    }
}
