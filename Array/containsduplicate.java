import java.util.*;

public class containsduplicate {
    // brute forse approach - not optimal solution
    // time complexity = O(n^2)
    // space complexity = O(1)
    public static boolean containsduplicate1(int arr[]) {
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //not optimal but better than above solution
    // time complexity = O(n log n)
    // space complexity = O(1)
    public static boolean containsduplicate2(int arr[]) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] == arr[i+1]) {
                return true;
            }
        }
        return false;
    }

    //optimal solution
    // time complexity = O(n)
    // space complexity = ?
    public static boolean containsduplicate3(int arr[]) {
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if(seen.contains(arr[i])) {
                return true;
            }
            seen.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3 ,4, 1, 6};
        System.out.println(containsduplicate1(arr));
        System.out.println(containsduplicate2(arr));
        System.out.println(containsduplicate3(arr));
    }
}
