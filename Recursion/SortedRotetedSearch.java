public class SortedRotetedSearch {
    // time complexity -> O(n)
    // space complexity -> O(n)
    public static int Search(int arr[], int i, int key){
        if(i == arr.length) return -1;
        if(arr[i] == key) {
            return i;
        }
        return Search(arr, i+1, key);
    }

    public static int Search2(int arr[], int si, int ei, int key) {
        if(si>ei) return -1;
        int mid = si + ( ei - si ) / 2;
        if(arr[mid] == key) {
            return mid;
        }
        if(arr[si] <= arr[mid]) {
            if(arr[si]<=key && key<=arr[mid]) {
                return Search2(arr, si, mid-1, key);
            } else {
                return Search2(arr, mid+1, ei, key);
            }
        } else {
            if(arr[mid+1]<=key && key<=arr[ei]) {
                return Search2(arr, mid+1, ei, key);
            } else {
                return Search2(arr, si, mid-1, key);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(Search2(arr, 0, arr.length-1, 3));
    }
}
