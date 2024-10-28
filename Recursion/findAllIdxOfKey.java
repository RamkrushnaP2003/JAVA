public class findAllIdxOfKey {
    public static void printEleIdx(int arr[], int i, int key) {
        if(i == arr.length) {
            System.out.println();
            return;
        } 

        if(arr[i] == key) {
            System.out.print(i+" ");
        }
        printEleIdx(arr, i+1, key);
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key = 2;
        printEleIdx(arr, 0, key);
    }
}
