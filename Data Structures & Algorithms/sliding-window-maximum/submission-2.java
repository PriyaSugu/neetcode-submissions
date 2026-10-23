class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        Deque<Integer> queue = new ArrayDeque<>();

        for(int left = 0, right = 0; right < n; right++){
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[right]){
                queue.removeLast();
            }
            queue.addLast(right);

            if(left > queue.getFirst()){
                queue.removeFirst();
            }

            if(right + 1 >= k){
                res[left] = nums[queue.getFirst()];
                left++;
            }
        }

        return res;
    }
}
