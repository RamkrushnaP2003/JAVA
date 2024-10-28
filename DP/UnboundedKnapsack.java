public class UnboundedKnapsack {
    // time complexity -> O(N*W)
    public static int knapsack(int val[], int wt[], int W) {
        int dp[][] = new int[val.length+1][W+1];
        for(int i=1; i<val.length+1; i++) {
            for(int j=1; j<=W; j++) {
                if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[val.length][W];
    }

    public static int knapsack(int val[], int wt[], int W, int i) {
        if(i == val.length) return 0;
        if(wt[i] <= W) {
            int inc = val[i]+knapsack(val, wt, W-wt[i], i);
            int exc = knapsack(val, wt, W, i+1);
            return Math.max(inc, exc);
        } else {
            return knapsack(val, wt, W, i+1);
        }
    }

    public static int knapsack(int val[], int wt[], int W, int dp[][], int i) {
        if(i==0) {
            return 0;
        }
        if(dp[i][W] != 0) {
            return dp[i][W];
        }
        if(wt[i-1] <= W) {
            int inc = val[i-1] + knapsack(val, wt, W-wt[i-1], dp, i);
            int exc = knapsack(val, wt, W, dp, i-1);
            dp[i][W] = Math.max(inc, exc);
            return dp[i][W];
        } else {
            dp[i][W] = knapsack(val, wt, W, dp, i-1);
            return dp[i][W];
        }
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapsack(val, wt, W));
        System.out.println(knapsack(val, wt, W, 0));
        System.out.println(knapsack(val, wt, W, new int[val.length+1][W+1], val.length));
    }
}
