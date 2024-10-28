public class WordSearch {
    public static boolean search(char[][] board, String word) {
        int k=0;
        boolean res = false;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(k) && k<word.length()) {
                    res = true;
                    if(k < word.length()-1) {
                        k++;
                    } 
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        char board[][] = {{'A', 'B', 'C', 'E'},
                         {'S', 'F', 'C', 'S'},
                         {'A', 'D', 'E', 'E'}};
        System.out.println(search(board, "ABCCE"));
    }
}
