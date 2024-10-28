public class MaximumGold {
    public static void maximumGold(int[][] grid, int i, int j, int[][] vis) {
        if(grid.length-1 == i && grid[0].length-1 == j) {
            print(vis);
            return;
        }
        if( i+1 < grid.length && grid[i+1][j] != 0 && vis[i+1][j] == 0) {
            vis[i][j] = grid[i][j];
            maximumGold(grid, i+1, j, vis);
            vis[i][j] = 0;
        }
        if(grid[i][j+1] != 0 && vis[i][j+1] == 0 && grid[0].length > j+1) {
            vis[i][j] = grid[i][j];
            maximumGold(grid, i, j+1, vis);
            vis[i][j] = 0;
        }
        if(grid[i-1][j] != 0 && vis[i-1][j] == 0 && 0 < i-1) {
            vis[i][j] = grid[i][j];
            maximumGold(grid, i-1, j, vis);
            vis[i][j] = 0;
        }
        if(grid[i][j-1] != 0 && vis[i][j-1] == 0 && 0 < j-1) {
            vis[i][j] = grid[i][j];
            maximumGold(grid, i, j-1, vis);
            vis[i][j] = 0;
        }
    }

    public static void print(int[][] vis) {
        for(int i=0; i<vis.length; i++) {
            for(int j=0; j<vis[0].length; j++) {
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int grid[][] = {{0, 6, 0},
                        {5, 8, 7},
                        {0, 9, 0}};
        int vis[][] = new int[grid.length][grid[0].length];
        maximumGold(grid, 0, 0, vis);
    }
}
