class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int pile : piles){
            r = Math.max(r, pile);
        }
        int minRate = r;

        while(l <= r){
            int m = l + (r-l)/2;
            int totalT = 0;
            for(int pile: piles){
                totalT +=  Math.ceil((double)pile/m);
            }
            if(totalT <= h){
                minRate = Math.min(minRate, m);
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return minRate;
    }
}
