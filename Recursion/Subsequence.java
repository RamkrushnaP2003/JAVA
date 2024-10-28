import java.util.ArrayList;

public class Subsequence {
    public static void subsequence(int arr[], int i, ArrayList<Integer> newArr) {
        if(i == arr.length) {
            System.out.println(newArr);
            return;
        }
        newArr.add(arr[i]);
        subsequence(arr, i+1, newArr);
        newArr.remove(newArr.size()-1);
        subsequence(arr, i+1, newArr);
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 2};
        subsequence(arr, 0, new ArrayList<Integer>());
    }
}