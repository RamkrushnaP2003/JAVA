import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubSequence {
    public static int lcs(int arr1[], int arr2[]) {
        int n=arr1.length, m=arr2.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lis(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i);
        }
        int arr2[] = new int[set.size()];
        int k=0;
        for(int i : set ){
            arr2[k++] = i; 
        }
        Arrays.sort(arr2);
        return lcs(arr, arr2);
    }

    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
        System.out.println(lis(arr));
    }
}
