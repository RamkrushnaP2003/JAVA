public class ClimbingStairs {
    // Using Recursion O(2^n)
    public static int climbingStairs(int n) {
        if(n<=0) return n+1;
        return climbingStairs(n-1) + climbingStairs(n-2);
    }

    // Using Iteration O(n)
    public static int climbingStairs2(int n) {
        int prev = 0;
        int curr = 1;
        int next = 0;
        for(int i=1; i<=n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return next;
    }

    // Using Memoization O(n)
    public static int climbingStairs(int dp[], int n) {
        if(n<=0) return n+1;
        if(dp[n] != 0) return dp[n];
        dp[n] = climbingStairs(dp, n-1) + climbingStairs(dp, n-2);
        return dp[n];
    }

    // Using Tabulation O(n)
    public static int climbingStairs(int n, int dp[]) {
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=5;
        int[] dp = new int[n+1];
        System.out.println(climbingStairs(n));
        System.out.println(climbingStairs2(n));
        System.out.println(climbingStairs(dp, n));
        System.out.println(climbingStairs(n, dp));
    }
}
