public class RottenOranges {
    public static void rottingOrange(int[][] grid, int n, int m) {
        if(grid == null || grid.length == 0) return;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    helper(grid, i, j, 2, n, m);
                }
            }
        }
        int min = 2;
        for(int[] i : grid) {
            for(int j : i) {
                if(j==1) {
                    System.out.println(-1);
                    return;
                } 
                min = Math.max(min, j);
            }
        }
        System.out.println(min-2);
    }

    // time complexity -> O(n*m)
    public static void helper(int[][] grid, int sr, int sc, int color, int n, int m) {
        if(sr < 0 || sc < 0 || sr >= n || sc == m || grid[sr][sc] == 0 || (1 < grid[sr][sc] && grid[sr][sc]<color)) {
            return;
        }
        grid[sr][sc] = color;
        helper(grid, sr, sc+1, color+1, n, m);//right
        helper(grid, sr-1, sc, color+1, n, m);//top
        helper(grid, sr, sc-1, color+1, n, m);//left
        helper(grid, sr+1, sc, color+1, n, m);//down
    }

    public static void main(String[] args) {
        // int[][] grid = {{2, 1, 1},
        //                 {1, 1, 0},
        //                 {0, 1, 1}};
        int[][] grid = {{0, 2}};
        int n = grid.length;
        int m=grid[0].length;
        rottingOrange(grid, n, m);
    }
}
