public class LongestCommonSubstr {
    public static int lcs(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        int dp[][] = new int[n+1][m+1];
        int maxSubStr = 0;
        for(int i=1;i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxSubStr = Math.max(maxSubStr, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxSubStr;
    }

    public static void main(String args[]) {
        String str1 = "ABCDE", str2 = "ABGCE";
        System.out.println(lcs(str1, str2));
    }
}
