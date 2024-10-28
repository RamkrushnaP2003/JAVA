public class findEle {
    // find first occurance
    // time and space complexity -> O(n);
    public static int firstPccurence(int arr[], int i, int key) {
        if(i == arr.length) return -1;
        if(arr[i] == key) return i;
        return firstPccurence(arr, i+1, key);
    }

    //find last occurance
    // time and space complexity -> O(n)
    public static int lastOccurence(int arr[], int i, int key) {
        if(i == -1) return -1;
        if(arr[i] == key) return i;
        return lastOccurence(arr, i-1, key);
    }

    //find last occurance
    // time and space complexity -> O(n)
    public static int lastOccurence2(int arr[], int key, int i) {
        if(i == arr.length) return -1;
        int isFound = lastOccurence2(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) {
            return i;
        } 
        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 3};
        // System.out.println(firstPccurence(arr, 0, 5));
        System.out.println(lastOccurence2(arr, 5, 0));
    }
}
