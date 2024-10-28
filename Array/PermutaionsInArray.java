import java.util.Arrays;

public class PermutaionsInArray {
    public static boolean isPossible(int a[], int b[], int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0; i<a.length; i++) {
            if( k > a[i]+b[a.length-i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 2, 1};
        int b[] = {3, 3, 3, 4};
        int k=5;
        System.out.println(isPossible(a, b, k));
    }
}
