public class NoOfCoins {
    public static int minCoins(int coins[], int v) {
        int count = 0;
        for(int i=0; i<coins.length; i++) {
            if(coins[i] <= v) {
                while (coins[i] <= v) {
                    v -= coins[i];
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int v = 11;
        System.out.println(minCoins(coins, v));
    }
}
