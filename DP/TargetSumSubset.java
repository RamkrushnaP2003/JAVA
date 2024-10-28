public class TargetSumSubset {
    public static boolean targetSumSubSet(int nums[], int taregt) {
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][taregt+1];
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = true;
        }        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(nums[i-1] <= j && dp[i-1][j-nums[i-1]]) {
                    dp[i][j] = dp[i-1][j-nums[i-1]];
                } else if(dp[i-1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        // printDP(dp);
        return dp[n][taregt];
    }

    public static boolean targetSum(int nums[], int i, int target, int sum) {
        if(sum == target) return true;
        if(i==nums.length) return false;
        return targetSum(nums, i+1, target, sum+nums[i]) || targetSum(nums, i+1, target, sum);
    }

    public static void printDP(boolean[][] dp) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print((dp[i][j] ? "T" : "F") + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int nums[] = {4, 2, 7, 1, 3};
        int targetSum = 20;
        System.out.println(targetSumSubSet(nums, targetSum));
        System.out.println(targetSum(nums, 0, targetSum, 0));
    }
}
