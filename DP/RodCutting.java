public class RodCutting {
    public static int rodCutting(int length[], int price[], int rodLength, int i) {
        if(i == length.length) return 0;
        if(length[i] <= rodLength) {
            int inc = price[i] + rodCutting(length, price, rodLength-length[i], i+1);
            int exc = rodCutting(length, price, rodLength, i+1);
            return Math.max(inc, exc);
        } else {
            return rodCutting(length, price, rodLength, i+1);
        }
    }

    public static int rodCutting(int length[], int price[], int rodLength) {
        int n = length.length;
        int dp[][] = new int[n+1][rodLength+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=rodLength; j++) {
                if(length[i-1] <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i-1][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rodLength];
    }

    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;
        System.out.println(rodCutting(length, price, rodLength));
        System.out.println(rodCutting(length, price, rodLength, 0));
    }
}
