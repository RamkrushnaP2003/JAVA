public class diagonalSum {
    // bruteForce Approach 
    // time complexity -> O(n^2)
    public static int DiagonalSum (int matrix[][]) {
        int n = matrix.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j || i + j == n-1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    // optimal Solution
    // time complexity -> O(n);
    public static int DiagonalSum2(int matrix[][]) {
        int sum = 0;
        for(int i=0; i<matrix.length; i++) {
            sum += matrix[i][i];
            if(i != matrix.length-1-i)
                sum += matrix[i][matrix.length-1-i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        System.out.println(DiagonalSum(matrix));
        System.out.println(DiagonalSum2(matrix));
    }
}
