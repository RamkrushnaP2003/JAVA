import java.util.Scanner;

public class creat2D {

    // time complexity -> O(n^2);
    public static boolean search(int arr[][], int key) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == key) {
                    System.out.println("Element found at (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static int largest(int arr[][]) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] > largest) {
                    largest = arr[i][j];
                }
            }
        }
        return largest;
    }

    public static int smallest(int arr[][]) {
        int smallest = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] < smallest) {
                    smallest = arr[i][j];
                }
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n=matrix.length, m=matrix[0].length;
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(search(matrix, 5));
        System.out.println(largest(matrix));
        System.out.println(smallest(matrix));
    }
}