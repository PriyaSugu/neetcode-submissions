class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int l = 0, r = 0;
        while(r < n){
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[r]){
                queue.removeLast();
            }
            queue.addLast(r);
            if(l > queue.getFirst()){
                queue.removeFirst();
            }
            if(r+1 >= k){
                res[l] = nums[queue.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
