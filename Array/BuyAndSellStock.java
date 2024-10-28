public class BuyAndSellStock {
    public static int BuyAndSellStocks (int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<price.length; i++) {
            if(buyPrice < price[i]) {
                int profit = price[i] - buyPrice;
                // maxProfit = Math.max(maxProfit, profit);
                if(maxProfit < profit) {
                    maxProfit = profit;
                }
            } else {
                buyPrice = price[i];
            }
        }
        return maxProfit;
    } 
    public static void main(String[] args) {
        int price[] = {7, 6, 4, 3, 1};
        System.out.println(BuyAndSellStocks(price));
    }
}
