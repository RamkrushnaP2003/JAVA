public class WordSearch {
    public static void isWordExist(char board[][], String word,int idx, int row, StringBuilder ans) {
        if(idx == word.length()) {
            System.out.println(ans);
            return;
        }
        char currChar = word.charAt(idx);
        for(int j=0; j<board.length; j++) {
            if(board[row][j] == currChar) {
                ans.append(currChar);
                isWordExist(board, word, idx+1, row+1, ans);
            }
        }
    }

    public static void main(String[] args) {
        char board[][] = {{'A', 'B', 'C', 'E'},
                          {'S', 'F', 'C', 'S'},
                          {'A', 'D', 'E', 'E'}};
        isWordExist(board, "ABCCFD", 0, 0, new StringBuilder());
    }
}
