class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minSoFar){
                minSoFar = prices[i];
            }else{
                profit = Math.max(profit, prices[i] - minSoFar);
            }
        }
        return profit;
    }
}
