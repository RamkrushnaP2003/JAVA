public class reverseArray {
    public static void reverse(int arr[], int left, int right) {
        if(left >= right) return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverse(arr, left+1, right-1);
    }

    public static void reverseArr(int arr[],int i) {
        if(i >= arr.length/2) return;
        int temp = arr[i];
        arr[i] = arr[arr.length-1-i];
        arr[arr.length-1-i] = temp;
        reverseArr(arr, i+1);
    }

    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        reverseArr(arr, 0);
        printArray(arr);
    }
}
