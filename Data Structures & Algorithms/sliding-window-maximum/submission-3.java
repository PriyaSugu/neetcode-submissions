class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int l = 0, r = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        while(r < n){
            while(!queue.isEmpty() && nums[r] > nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(r);

            if(l > queue.peek()){
                queue.poll();
            }

            if((r + 1) >= k){
                res[l] = nums[queue.peek()];
                l++;
            }
            r++;
        }
        return res;
    }
}
