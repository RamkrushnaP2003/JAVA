public class FloodFill {
    public static void floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int orgColor = image[sr][sc];
        helper(image, sr, sc, color, n, m, orgColor);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void helper(int[][] image, int sr, int sc, int color, int n, int m, int orgColor) {
        if(sr < 0 || sc < 0 || sr == n || sc == m || image[sr][sc] != orgColor) {
            return;
        }
        image[sr][sc] = color;
        helper(image, sr, sc+1, color, n, m, orgColor);//right
        helper(image, sr-1, sc, color, n, m, orgColor);//top
        helper(image, sr, sc-1, color, n, m, orgColor);//left
        helper(image, sr+1, sc, color, n, m, orgColor);//down
    }

    public static void main(String[] args) {
        int image[][] = {{0, 1, 1},
                         {1, 1, 0},
                         {1, 0, 1}};
        int sr = 1, sc = 1, color = 2;
        floodFill(image, sr, sc, color);
    }
}
