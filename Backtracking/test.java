public class test {
    public static void tests(char board[][], int row) {
        if(row == 2) {
            System.out.println("____________");
            for(int i=0; i<2; i++) {
                for(int j=0; j<2; j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        
        for(int j=0; j<2; j++) {
            board[row][j] = 'Q';
            tests(board, row+1);
            board[row][j] = 'X';
        }
    }

    public static void main(String[] args) {
        char board[][] = new char[2][2];
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                board[i][j] = 'X';
            }
        }
        tests(board, 0);
    }
}
