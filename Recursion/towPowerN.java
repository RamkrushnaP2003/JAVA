public class towPowerN {
    //time complexity -> O(n)
    public static int twoToThePowerN(int x, int n) {
        if(n == 0) {
            return 1;
        }
        // int xnm1 = twoToThePowerN(x, n-1);
        // int res = x * xnm1;
        // return res;
        return x * twoToThePowerN(x, n-1);
    }

    // time complexity -> O(log n)
    // space complexity -> O(log n)
    public static int xpowern(int x, int n) {
        if(n == 0) {
            return 1;
        }
        int halfPower = xpowern(x, n/2);
        int halfPowerSq = halfPower * halfPower;
        if( n % 2 == 0 ) {
            return halfPowerSq;
        }
        return halfPowerSq * x;
    }
    public static void main(String[] args) {
        int n=10;
        System.out.println(xpowern(2, n));
    }
}
