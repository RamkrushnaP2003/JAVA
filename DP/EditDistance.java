import java.util.Arrays;

public class EditDistance {
    public static int editDist(String word1, String word2, int n, int m) {
        if(n==0 || m==0) return 0;
        if(word1.charAt(n-1) == word2.charAt(m-1)) {
            return editDist(word1, word2, n-1, m-1);
        } else {
            return Math.min(editDist(word1, word2, n-1, m-1), Math.min(editDist(word1, word2, n-1, m), editDist(word1, word2, n, m-1))) + 1;
        }
    }

    public static int editDist(String str1, String str2, int n, int m, int dp[][]) {
        if(n==0 || m==0) return 0;
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            dp[n][m] = editDist(str1, str2, n-1, m-1, dp);
            return dp[n][m];
        } else {
            dp[n][m] = Math.min(editDist(str1, str2, n-1, m-1, dp), Math.min(editDist(str1, str2, n-1, m, dp), editDist(str1, str2, n, m-1, dp))) + 1;
            return dp[n][m];
        }
    }

    public static int editDist(String word1, String word2) {
        int n=word1.length(), m=word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = i;
        }
        for(int j=0; j<=m; j++) {
            dp[0][j] = j;
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int add = dp[i][j-1];
                    int del = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = Math.min(add, Math.min(del, replace))+1;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        System.out.println(editDist(word1, word2));
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i[] : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(editDist(word1, word2, word1.length(), word2.length(), dp));
    }
}
