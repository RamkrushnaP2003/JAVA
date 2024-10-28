public class HeapSort {
    public static void heapifyAsc(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if(left < size &&  arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if(right < size &&  arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if(maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapifyAsc(arr, maxIdx, size);
        }
    }
    
    public static void sortAsc(int arr[]) {
        int n = arr.length;
        // step 1 -> Build max heap
        for(int i=n/2; i>=0; i--) {
            heapifyAsc(arr, i, n);

        }

        // step 2 -> puch larget at end
        for(int i=n-1; i>0; i--) {
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapifyAsc(arr, 0, i);
        }
    }

    public static void heapifyDesc(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;
        if(left < size && arr[left] < arr[minIdx]) {
            minIdx = left;
        }
        if(right < size && arr[right] < arr[minIdx]) {
            minIdx = right;
        }
        if(minIdx != i) {
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            heapifyDesc(arr, minIdx, size);
        }
    }

    public static void sortDesc(int arr[]) {
        int n = arr.length;
        for(int i=n/2; i>0; i--) {
            heapifyDesc(arr, i, n);
        }

        for(int i=n-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapifyDesc(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 3};
        sortAsc(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        sortDesc(arr);
        System.out.println();
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
