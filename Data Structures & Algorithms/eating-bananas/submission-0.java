class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int p: piles){
            r = Math.max(r, p);
        }
        int res = 0;

        while(l <= r){
            int k = (l + r)/2;
            int total = 0;
            for(int p: piles){
                total += Math.ceil((double) p / k);
            }
            if(total <= h){
                res = k;
                r = k - 1;
            }else{
                l = k + 1;
            }
        }
        return res;
    }
}
