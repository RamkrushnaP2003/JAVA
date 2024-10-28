public class NQueens {
    // static int count = 0;
    // // time complexity -> O(n!)
    // public static void nQUeens(char board[][], int row) {
    //     if( row == board.length ) {
    //         printBoard(board);
    //         count++;// return no of solution is possible
    //         return;
    //     }
    //     for(int j=0; j<board.length; j++) {
    //         if(isSafe(board, row, j)) {
    //             board[row][j] = 'Q';
    //             nQUeens(board, row+1);
    //             board[row][j] = 'X';// if cant backtrack then attacking each other
    //         }
    //     }
    // }

    // public static boolean isSafe(char board[][], int row, int col) {
    //     //vetical up
    //     for(int i=row-1; i>=0; i--) {
    //         if(board[i][col]=='Q') {
    //             return false;
    //         }
    //     }
    //     // diagonal left
    //     for(int j=col, i=row; i>=0&& j>=0;i--, j--) {
    //         if(board[i][j]=='Q') {
    //             return false;
    //         }
    //     }
    //     // doagonal right
    //     for(int j=col+1, i=row-1; i>=0&& j<board.length;i--, j++) {
    //         if(board[i][j]=='Q') {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    static int count = 0;
    public static int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        queens(board, 0);
        return count;
    }
    public static void queens(char board[][], int row) {
        if(row == board.length) {
            count++;
            return;
        }
        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                queens(board, row+1);
                board[row][j] = '.';
            }
        }
    }
    public static boolean isSafe(char board[][], int row, int col) {
        for(int i=row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
            if(board[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }

    
    public static void printBoard(char board[][]) {
        System.out.println("--------Chess Board--------");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 1;
        // char board[][] = new char[n][n];
        // for(int i=0; i<board.length; i++) {
        //     for(int j=0; j<board.length; j++) {
        //         board[i][j] = 'X';
        //     }
        // }
        totalNQueens(n);
        System.out.println(count);
    }
}
