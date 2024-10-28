public class RatInMaze3 {
    public static boolean sol(int maze[][]) {
        int n = maze.length;
        int vis[][] = new int[n][maze[0].length];
        if(ratInMaze(maze, vis, 0, 0, n, n) == false) {
            return false;
        }
        return true;
    }

    public static boolean ratInMaze(int maze[][],int vis[][], int row, int col, int n, int m) {
        if(row == n-1 && col == m-1 && maze[row][col]==1) {
            vis[row][col] = 1;
            return true;
        }
        if(isSafe(maze, row, col)) {
            if(vis[row][col]==1) {
                return false;
            }
            vis[row][col] = 1;
            if(ratInMaze(maze, vis, row+1, col, n, m)) {
                return true;
            }
            if(ratInMaze(maze, vis, row, col+1, n, m)) {
                return true;
            }
            vis[row][col] = 0;
            return false;
        }
        return false;
    }

    public static boolean isSafe(int maze[][], int row, int col) {
        return (row>=0 && col>=0 && row<maze.length && col<maze[0].length && maze[row][col]==1);
    }

    public static void printMaze(int vis[][]) {
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
                        {1, 0, 1, 1}};
        int vis[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        if(ratInMaze(maze, vis, 0, 0, maze.length, maze[0].length)) {
            printMaze(vis);
        } else {
            System.out.println("Solution is not found");
        }
    }
}