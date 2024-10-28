public class PeakIdxInMountainArray {
    // time complexity -> O(n)
    public static int peakIdxInMountainArray(int arr[]) {
        int n=arr.length;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;
        for(int i=1; i<n-1; i++) {
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                return i;
            }
        }
        return -1;
    }

    // time complexity -> O(logn)
    public static int peakIdxInMountainArray2(int arr[]) {
        int n=arr.length;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;
        int left = 1;
        int right = n-2;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(arr[mid-1] < arr[mid]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid+1]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,3,2,0};
        System.out.println(peakIdxInMountainArray2(arr));
    }
}