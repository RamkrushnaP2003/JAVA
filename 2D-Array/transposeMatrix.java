public class transposeMatrix {
    public static void TransposeMatrix(int arr[][]) {
        int row = arr.length;
        int col = arr[0].length;

        System.out.println("Original matrix");
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int transpose[][] = new int[col][row];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                transpose[j][i] = arr[i][j];
            }
        }

        System.out.println("Transposed matrix");
        for(int i=0; i<col; i++) {
            for(int j=0; j<row; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}};
        TransposeMatrix(arr);
    }
}