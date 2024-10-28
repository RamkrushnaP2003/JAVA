public class reveseArray {
    //not optimal solution it
    // time complexity = O(n);
    // space comlexity = O(1) -> it take auxillary space to reverse array
    public static void reveseAnArray(int arr[]) {
        for(int i=arr.length-1; i>=0; i--) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void reverseArr(int arr[]) {
        int start = 0;
        int end = arr.length-1;
        for(int i=0; i<arr.length/2; i++) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 ,5 ,6};
        reverseArr(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
