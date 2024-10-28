public class Search2DMatrix2 {
    // time complexity -> O(n)
    public static boolean searchMatrix(int matrix[][], int target) {
        int n=matrix.length, m=matrix[0].length;
        int i=n-1, j=0;
        while(j < m && i >= 0) {
            if(matrix[i][j] == target) {
                return true;
            }
            if(matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int matrix[][], int target) {
        int row=0, col=matrix[0].length-1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            }
            if(matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        System.out.println(searchMatrix2(matrix, 5));
    }
}
