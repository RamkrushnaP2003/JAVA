public class NKnights {

    // wrong code need to improve
    public static boolean knight(char board[][], int row, int col, int k) {
        if(k == 0) {
            return true;
        }
        int nextRow = row, nextCol = col+1;
        if(col+1 == board.length) {
            nextRow = row+1;
            nextCol = 0;
        }
        for(int i=0; i<board.length; i++) {
            if(isSafe(board, row, col)) {
                board[row][i] = 'K';
                if(knight(board, nextRow, nextCol, k-1)) {
                    return true;
                }
                board[row][i]='.';
            }
        }
        return false;
    }

    public static boolean isValid(char board[][], int row, int col) {
        return (row>=0 && col>=0 && row<board.length && col<board.length);
    }

    public static boolean isSafe(char board[][], int row, int col) {
        if(isValid(board, row-2, col-1)) {
            if(board[row][col]=='K') {
                return false;
            }
        }
        if(isValid(board, row-2, col+1)) {
            if(board[row][col]=='K') {
                return false;
            }
        }
        if(isValid(board, row-1, col-2)) {
            if(board[row][col]=='K') {
                return false;
            }
        }
        if(isValid(board, row-1, col+2)) {
            if(board[row][col]=='K') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("----Chess Board----");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 4;
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        if(knight(board, 0, 0, n)) {
            printBoard(board);
        } else {
            System.out.println("Not fount");
        }
    }
}
