public class StringConversion {
    public static int stringConversion(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = i;
        }
        for(int j=0; j<=m; j++) {
            dp[0][j] = j;
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int add = dp[i][j-1];
                    int del = dp[i-1][j];
                    dp[i][j] = Math.min(add, del)+1;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String args[]) {
        String str1 = "abcdefg";
        String str2 = "aceg";
        System.out.println(stringConversion(str1, str2));
    }
}
