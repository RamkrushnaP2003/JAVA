public class Tiling {
    // time complexity -> O(2^n)
    public static int tilingProblem(int n) { // 2 * n
        if(n == 0 || n == 1) {
            return 1;
        }
        // kaam
        int  verticalTiles = tilingProblem(n-1);
        int horizontalTiles = tilingProblem(n-2);
        int totalWays = verticalTiles + horizontalTiles;
        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(tilingProblem(4));
    }
}
