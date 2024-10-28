public class PerfectNum {
    public static void nPerfectNum(int n) {
        for(int i=1; i<=n; i++) {
            if(isPerfect(i)) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static boolean isPerfect(int n) {
        int sum=1;
        for(int i=2; i<=n/2; i++) {
            if(n%i==0) {
                sum+=i;
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        int n = 1000;
        nPerfectNum(n);
    }
}