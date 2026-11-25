class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(!queue.isEmpty() && queue.peekFirst() <= i - k){
                queue.pollFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if(i >= k - 1){
                res[idx++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
