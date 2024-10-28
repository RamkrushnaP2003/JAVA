public class WordSearch {
    public static boolean floodFill(char[][] board, String ans) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == ans.charAt(0)) {
                    if(helper(board, i, j, ans, new boolean[board.length][board[0].length], 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean isFound = false;

    public static boolean helper(char[][] board, int i, int j, String ans, boolean vis[][], int k) {
        if(k == ans.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j] || board[i][j] != ans.charAt(k)) {
            return false;
        }
        vis[i][j] = true;
        if(helper(board, i, j+1, ans, vis, k+1)|| helper(board, i-1, j, ans, vis, k+1)|| helper(board, i, j-1, ans, vis, k+1) || helper(board, i+1, j, ans, vis, k+1)) {
            return true;
        }
        vis[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                          {'S', 'F', 'C', 'S'},
                          {'A', 'D', 'E', 'E'}};
        String ans = "ABCED";
        System.out.println(floodFill(board, ans));
    }
}