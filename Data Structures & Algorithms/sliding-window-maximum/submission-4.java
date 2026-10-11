class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        while(r < n){
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[r]){
                deque.removeLast();
            }
            deque.addLast(r);

            if(l > deque.peek()){
                deque.poll();
            }

            if(r-l+1 == k){
                res[l] = nums[deque.peek()];
                l++;
            }
            r++;
        }

        return res;
    }
}
