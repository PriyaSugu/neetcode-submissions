class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[(nums.length-k+1)];
        int l = 0, r = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        while(r < nums.length){
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[r]){
                queue.removeLast();
            }
            queue.addLast(r);

            if(l > queue.getFirst()){
                queue.removeFirst();
            }

            if((r+1) >= k){
                res[l] = nums[queue.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
