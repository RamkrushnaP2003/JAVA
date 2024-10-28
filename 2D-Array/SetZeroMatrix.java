public class SetZeroMatrix {
    // 1) Brute Force Approach
    // time complexity -> O[(n*m)*(n+m)+(m*n)] = O(n^3)
    public static void setZeroMatrix(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    markRow(i, matrix);
                    markCol(j, matrix);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
        printMatrix(matrix);
    }

    public static void markRow(int i,int matrix[][]) {
        int m = matrix[0].length;
        for(int j=0; j<m; j++) {
            if(matrix[i][j] != 0) {
                matrix[i][j]=-1;
            }
        }
    }

    public static void markCol(int j, int matrix[][]) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            if(matrix[i][j] != 0) {
                matrix[i][j]=-1;
            }
        }
    }

    public static void printMatrix(int matrix[][]) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    // time complexity -> O(n^2)
    // space complexity -> O(m+n)
    public static void setZeroMatrix2(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row[] = new int[n], col[] = new int[m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(col[j] == 1 || row[i] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        printMatrix(matrix);
    }

    // optimal approach 
    // time complexity -> O(n^2)
    // space complexity -> O(1)
    public static void setZeroMatrix3(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length; 
        int col0 = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if(j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0) {
            for(int i=0; i<n; i++) {
                matrix[i][0] = 0;
            }
        }
        if(col0 == 0) {
            for(int j=0; j<m; j++) {
                matrix[0][j] = 0;
            }
        }
        printMatrix(matrix);
    }

    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 2, 0},
                          {3, 4, 5, 6},
                          {1, 2, 3,1}};
        setZeroMatrix3(matrix);
    }
}
