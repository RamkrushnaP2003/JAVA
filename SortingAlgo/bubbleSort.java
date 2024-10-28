package SortingAlgo;

public class bubbleSort {
    // time complexity -> O(n^2)
    // space complexity -> O(1)
    // this is not optimal solution for sorted array
    public static void bubbleSortAlgo(int arr[]) {
        int swap = 0;
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap++;
                }
            }
        }
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        if(swap == 0) {
            System.out.println("Array was already sorted");
        }
        System.out.println(swap);
    }

    // optimal solution for sorted array 
    public static void bubbleSort1(int arr[]) {
        System.out.print(arr[0]+" ");
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] < arr[i+1]) {
                System.out.print(arr[i+1] + " ");
            }
        }
    }

    // decsending order -> Bubble sort
    public static void bubbleSortDecs(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;    
                }
            }
        }
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 1, 3, 2};
        bubbleSortDecs(arr);
    }
}
