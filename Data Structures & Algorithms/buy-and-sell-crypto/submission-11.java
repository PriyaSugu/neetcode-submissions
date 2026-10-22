class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = 101;
        int maxProfit = 0;

        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(price-minPrice, maxProfit);
        }

        return maxProfit;
        
    }
}
