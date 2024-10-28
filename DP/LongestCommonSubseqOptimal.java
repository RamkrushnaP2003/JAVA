public class LongestCommonSubseqOptimal {
    public static int lcs(String str1, String str2, int n, int m) {
        if(n==0 || m==0) return 0;
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return lcs(str1, str2, n-1, m-1)+1;
        } else {
            return Math.max(lcs(str1, str2, n-1, m), lcs(str1, str2, n, m-1));
        }
    }

    public static int lcs(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        if(n==0 || m==0) return 0;
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<=m; j++) {
            dp[0][j] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    sb.append(str1.charAt(i-1));
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(sb);
        return dp[n][m];
    }

    public static int lcs(String str1, String str2, int n, int m, int dp[][]) {
        if(n==0 || m==0) return 0;
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            dp[n][m] = lcs(str1, str2, n-1, m-1, dp) + 1;
            return dp[n][m];
        } else {
            dp[n][m] = Math.max(lcs(str1, str2, n-1, m, dp), lcs(str1, str2, n, m-1, dp));
            return dp[n][m];
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdge", str2 = "abdg";
        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        System.out.println(lcs(str1, str2));
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(lcs(str1, str2, str1.length(), str2.length(), dp));
    }
}
