public class ClimbingStairs {
    // You are climbing a staircases. It take n steps to reach the top
    // Eact time you can either climb 1 or 2 steps. 
    // In how many distings ways you climb to the top

    // time complexity -> O(2^n)
    public static int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static int climbStairs2(int n){
        int p = 0;
        int c = 1;
        int next = 0;
        for(int i=0; i<n; i++) {
            next = p + c;
            p = c;
            c = next;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs2(45));
        System.out.println(climbStairs(45));
    }
}
