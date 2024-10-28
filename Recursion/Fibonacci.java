public class Fibonacci {
    public static int fibo1(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int fnm1 = fibo1(n-1);
        int fnm2 = fibo1(n-2);
        int fibo = fnm1 + fnm2;
        return fibo;
        // if(n == 0 || n == 1) return n;
        // return fibo(n-1) + fibo(n-2);
    }
    
    // time complexity -> O(2^n)
    // space complexity -> O(n)
    public static int fibo2(int n) {
        return n == 1 || n == 0 ? n : fibo2(n-1) + fibo2(n-2);
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(fibo1(n));
    }
}
