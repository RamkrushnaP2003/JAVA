public class stairCaseSearch {
    //Downword search
    // time complexity -> O(n+m)
    public static boolean StairCaseSearch(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0, col = m-1;
        while(row<n && col>=0) {
            if(matrix[row][col] == key) {
                System.out.println("key found at (" + row + "," + col + ")");
                return true;
            }
            else if (matrix[row][col] > key) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    //Upword search
    // time complexity -> O(n+m)
    public static boolean StairCaseSearch2(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = n-1, col = 0;
        while(row>=0 && col < m) {
            if(matrix[row][col] == key) {
                System.out.println("Key found at (" + row + "," + col + ")");
                return true;
            } else if (matrix[row][col] < key) {
                col++;
            } else {
                row--;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    // BinarySearch in 2D Array
    // not optimal approach 
    // time complexity -> O(n log n)
    public static boolean BinarySearch(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++) {
            int start=0;
            int end=m-1;
            while(start<=end) {
                int mid=(start+end)/2;
                if(matrix[i][mid]==key) {
                    return true;
                } else if (matrix[i][mid] < key) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    // binary search
    // Auxillary Array Taking -> Space complexity O(m*n)
    // time complexity -> O(log n)
    public static boolean BinarySearch2 (int matrix[][], int key) {
        int n = matrix.length * matrix[0].length;
        int newArr[] = new int[n];
        int k=0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                newArr[k] = matrix[i][j];
                k++;
            }
        }
        for(int i=0; i<n; i++) {
            System.out.print(newArr[i]+" ");
        }
        int start = 0;
        int end = n-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(newArr[mid]==key) {
                return true;
            } 
            if(newArr[mid]<key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    // linear search
    // brute force approach 
    // time complexity -> O(n * m)
    public static boolean search(int matrix[][], int key) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == key) {
                    return true;
                }
            }
        }
        return false;
    }

    // optimal approach
    // time complexity -> O(log (m*n))
    public static boolean BinarySearch3(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = (n * m)-1;
        while(start<=end) {
            int mid = (start + end) / 2;
            if(matrix[mid/m][mid%m] == key) {
                return true;
            }
            if(matrix[mid/m][mid%m] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}};
        System.out.println(BinarySearch3(matrix, 11));
    }
}
