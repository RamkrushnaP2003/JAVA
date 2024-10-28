import java.util.Arrays;

public class MinAbsDiffPair {
    // time complexity -> O(n log nf)
    public static int MinAbsDiff(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff = 0;
        for(int i=0; i<A.length; i++) {
            minDiff += Math.abs(A[i]-B[i]);
        }
        return minDiff;
    }
    public static void main(String[] args) {
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 6, 3, 5};
        System.out.println(MinAbsDiff(A, B));
    }
}
