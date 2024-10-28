public class RatInMaze {
    // Direction printiting
    // time complexity -> O(4^(n*m))
    // space complexity -> O(4^(n*m))
    public static void mazegame(int maze[][], int row, int col, int n, int m, String moves, int vis[][]){
        if(row == n-1 && col == m-1) {
            print(vis);
            System.out.println(moves);
            return;
        }

        if(maze[0][0] == 0) {
            System.out.println("Solution is not found");
            return;
        }
        // Down
        if(row+1<n && vis[row+1][col]==0 && maze[row+1][col] == 1) {
            vis[row][col] = 1;
            mazegame(maze, row+1, col, n, m, moves+"D ", vis);
            vis[row][col] = 0;
        }
        // Left
        if(col-1>=0 && maze[row][col-1]==1 && vis[row][col-1]==0) {
            vis[row][col] = 1;
            mazegame(maze, row, col-1, n, m, moves+"L ", vis);
            vis[row][col]=0;
        }
        // Right
        if(col+1<m && maze[row][col+1]==1 && vis[row][col+1]==0) {
            vis[row][col]=1;
            mazegame(maze, row, col+1, n, m, moves+"R ", vis);
            vis[row][col]=0;
        }
        // Up
        if(row-1>=0 && maze[row-1][col]==1 && vis[row-1][col]==0) {
            vis[row][col] = 1;
            mazegame(maze, row-1, col, n, m, moves+"U ", vis);
            vis[row][col]=0;
        }
    } 

    public static void ratinmaze2(int maze[][], int vis[][], int row, int col, int n, int m, String moves, int dirRow[], int dirCol[]) {
        if(row == n-1 && col == m-1) {
            System.out.println(moves);
            return;
        }
        String dir = "DLRU";
        for(int i=0; i<4; i++) {
            int nextRow = row + dirRow[i];
            int nextCol = col + dirCol[i];
            if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && vis[nextRow][nextCol]==0 && maze[nextRow][nextCol]==1) {
                vis[row][col] = 1;
                ratinmaze2(maze, vis, nextRow, nextCol, n, m, moves+dir.charAt(i)+" ", dirRow, dirCol);
                vis[row][col] = 0;
            }
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
        int maze[][] = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 1, 0},
                        {1, 1, 1, 1}};
        int vis[][] = {{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0}};
        mazegame(maze, 0, 0, maze.length, maze[0].length, "", vis);
        int dirRow[] = {1, 0, 0, -1};
        int dirCol[] = {0, -1, 1, 0};
        System.out.println("-------------------");
        ratinmaze2(maze, vis, 0, 0, maze.length, maze[0].length, "", dirRow, dirCol);
    }
}
