public class QuickSort {
    public static void quickSort(int arr[], int si, int ei) {
        if(si>=ei) return;
        // last element -> pivot
        int pidx = partition(arr, si, ei);
        quickSort(arr, si, pidx-1); // left
        quickSort(arr, pidx+1, ei); // right
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1; // to make placre for element smaller than pivot
        for(int j=si; j<ei; j++) {
            if(arr[j]<=pivot) {
                i++;
                swap(arr, j, i);
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
