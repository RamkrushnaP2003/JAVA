public class sumOfN {
    public static int sumOfFisrtN(int n) {
        if(n==1) {
            return 1;
        }
        int sum = n + sumOfFisrtN(n-1);
        return sum;
    }

    public static void sumOfFisrtN2(int n, int sum) {
        if(n==0) {
            System.out.println(sum);
            return;
        }
        sumOfFisrtN2(n-1, sum+n);
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(sumOfFisrtN(n));
        sumOfFisrtN2(n, 0);
    }
}
