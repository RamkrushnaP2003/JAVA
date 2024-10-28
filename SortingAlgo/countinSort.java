package SortingAlgo;

public class countinSort {
    //time complexity -> O(n^2)
    // it is mainly used for min value e -> 1 - 7;
    public static void countingSortAlgo(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++) {
            count[arr[i]]++;
        }

        int j=0;
        for(int i=0; i<count.length; i++) {
            while(count[i]>0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 2, 6, 2, 7, 1};
        countingSortAlgo(arr);
    }
}
