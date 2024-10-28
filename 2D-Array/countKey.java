public class countKey {
    // time complexity -> O(nm)
    public static int countKeys(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == key) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int matrix[][] = {{4, 7, 8}, {8, 8, 7}};
        System.out.println(countKeys(matrix, 7));
    }
}
