public class Fibo {
    // using memoization
    public static int fibo(int n, int[] f) {
        if(n==0 || n==1) return n;
        if(f[n] != 0) {
            return f[n];
        }
        f[n] = fibo(n-1, f) + fibo(n-2, f); 
        return f[n];
    }

    // using iteration
    public static int fibo(int n) {
        if(n<=1) return n;
        int next = 0;
        int prev=0, curr=1;
        for(int i=2; i<=n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return next;
    }

    // using tabulation
    public static void fibo(int[] dp, int n) {
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        for(int i: dp) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n+1];
        System.out.println(fibo(n, f));
        System.out.println(fibo(n));
        // System.out.println(n*(n+1)/2);
        int[] dp = new int[n+1];
        fibo(dp, n);
        
    }
}