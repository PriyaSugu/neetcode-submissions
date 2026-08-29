class Solution {
    public int arrangeCoins(int n) {
        
        int left = 1, right = n;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long coins = (long) mid * (mid + 1) / 2;
            if (coins <= n) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}