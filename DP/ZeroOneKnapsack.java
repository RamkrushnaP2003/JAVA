public class ZeroOneKnapsack {
    // time complexity -> O(2^n)
    public static int knapsack(int val[], int[] wt, int W, int n){
        if(W==0 || n<0) return 0;
        if(wt[n] <= W) {
            int ans1 = val[n] + knapsack(val, wt, W-wt[n], n-1);
            int ans2 = knapsack(val, wt, W, n-1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, n-1);
        }
    }

    // time complexity -> O(n*W)
    public static int knapsack2(int[] val, int wt[], int W, int n, int dp[][]) {
        if(W==0 || n==0) {
            return 0;
        } 
        if(dp[n][W] != -1) {
            return dp[n][W];
        }
        if(wt[n-1]<=W) {
            int ans1 = val[n-1] + knapsack2(val, wt, W-wt[n-1], n-1, dp);
            int ans2 = knapsack2(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = knapsack2(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static int knapsack3(int[] val, int wt[], int W) {
        int dp[][] = new int[val.length+1][W+1];
        for(int i=1;i<dp.length;i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(wt[i-1] <= j) {
                    // val[i-1] = ith index int val Array & dp[i-1][j-wt[i-1]] = previous stored knapsack value in DP
                    int incProfit = val[i-1] + dp[i-1][j-wt[i-1]];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        printDP(dp);
        return dp[val.length][W];
    }

    public static void printDP(int[][] dp) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W=7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0; i<val.length+1; i++) {
            for(int j=0; j<W+1; j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapsack(val, wt, W, val.length-1));
        // System.out.println(knapsack2(val, wt, W, val.length, dp));
        
        System.out.println(knapsack3(val, wt, W));
    }
}