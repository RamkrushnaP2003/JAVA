public class RotateImage {
    // brute force approach -> not optimal solution
    // time complexity -> O(n^2)
    // space complexity -> O(n^2)
    public static void rotateImage(int matrix[][]) {
        int n = matrix.length;
        int ans[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        printMatrix(matrix);
    }

    public static void rotateImage2(int matrix[][]) {
        int n = matrix.length;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }  
        printMatrix(matrix);     
    }

    public static void printMatrix(int matrix[][]) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        System.out.println("Original Matrix");
        printMatrix(matrix);
        System.out.println("After rotate of 90deg");
        rotateImage2(matrix);
    }
}
