public class MS {
    public static void MergeSort(int arr[], int si, int  ei) {
        if(si>=ei) return;
        int mid = si + (ei - si) / 2;
        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1, ei);
        Merge(arr, si, mid, ei);
    }

    public static void Merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si;
        int j=mid+1;
        int k = 0;
        while(i<=mid && j<=ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid) {
            temp[k++] = arr[i++];
        }
        while(j<=ei) {
            temp[k++] = arr[j++];
        }
        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        MergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
