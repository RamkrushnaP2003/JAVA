public class InverseCount {
    static int count = 0;
    public static int inverseCount(int arr[], int si, int ei) {
        int invCount = 0;
        if(ei > si) {
            int mid = si+(ei-si)/2;
            invCount = inverseCount(arr, si, mid);
            invCount += inverseCount(arr, mid+1, ei);
            invCount += merge(arr, si, mid+1, ei);
        }
        return invCount;
    }

    public static int merge(int arr[], int si, int mid, int ei) {
        int i=si;
        int j=mid;
        int k=0;
        int invCount = 0;
        int temp[] = new int[ei-si+1];
        while(i<mid && j<=ei) {
            if(arr[i]<=arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount+=(mid-i);
            }
        }
        while(i<mid) {
            temp[k++] = arr[i++];
        }
        while(j<=ei) {
            temp[k++] = arr[j++];
        }
        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
        return invCount;
    }

    public static int getInversion(int arr[]) {
        int n=arr.length;
        return inverseCount(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5, 9, 5, 3};
        System.out.println(getInversion(arr));
    } 
}
