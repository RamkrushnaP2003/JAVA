public class BinarySearch {
    public static int Search(int arr[], int si, int ei, int key) {
        if(si > ei) return -1;
        int mid = si + ( ei - si ) / 2;
        if(arr[mid] == key) {
            return mid;
        }
        if(arr[mid] >= key) {
            return Search(arr, si, mid-1, key);
        } else {
            return Search(arr, mid+1, ei, key);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Search(arr, 0, arr.length-1, 5));
    }
}