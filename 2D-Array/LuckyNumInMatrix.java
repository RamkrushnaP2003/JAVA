import java.util.*;

public class LuckyNumInMatrix {
    public static ArrayList<Integer> luckyNums(int[][] matrix, ArrayList<Integer> luckyNums) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(isLucky(matrix, matrix[i][j], i, j)) {
                    luckyNums.add(matrix[i][j]);
                }
            }
        }
        return luckyNums;
    }

    public static boolean isLucky(int matrix[][], int num, int row, int col) {
        for(int i=0; i<matrix.length; i++) {
            if(num != matrix[i][col] && num < matrix[i][col]) {
                return false;
            }
        }
        for(int i=0; i<matrix[0].length; i++) {
            if(num != matrix[row][i] && num > matrix[row][i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 10, 4, 2},
                          {9, 3, 8, 7},
                          {15, 16, 17, 12}};
        ArrayList<Integer> luckyNums = new ArrayList<>();
        System.out.println(luckyNums(matrix, luckyNums));
    }
}
