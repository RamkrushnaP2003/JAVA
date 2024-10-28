public class GridWays {
    // time complexity -> O(2^(n+m))
    public static int gridWays(int row, int col, int n, int m) {
        if(row == n-1 || col == m-1) { // condition for last cell
            return 1;
        } else if(n == row || m == col) { // boundary cross condition
            return 0;
        }
        int way1 = gridWays(row+1, col, n, m);
        int way2 = gridWays(row, col+1, n, m);
        return way1 + way2;
    }

    public static int fact(int n) {
        if(n == 0) return 1;
        int fact = 1;
        for(int i=1; i<=n; i++) {
            fact *= i;
        }
        return fact;
    }

    // time complexity -> O(n)
    public static int gridWays2(int n, int m) {
        return (fact((n-1)+(m-1)))/(fact(n-1)*(fact(m-1)));
    }

    public static void main(String[] args) {
        int n=3; int m=3;
        System.out.println(gridWays(0, 0, n, m));
        System.out.println(gridWays2(n, m));
    }
}
