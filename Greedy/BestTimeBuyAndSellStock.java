public class BestTimeBuyAndSellStock {
    public static int buyAndSellStock(int price[]) {
        int buyPrice = price[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i=1; i<price.length; i++) {
            int sellPrice = price[i];
            if(buyPrice < sellPrice) {
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice =  sellPrice;
            }
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }

    public static void main(String[] args) {
        int price[] = {7, 1, 5, 3, 6, 4};
        System.out.println(buyAndSellStock(price));
    }
}
