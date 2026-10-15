class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices){
            profit = Math.max(profit, price - minSoFar);
            minSoFar = Math.min(minSoFar, price);
        }

        return profit;
    }
}
