import java.util.Arrays;

public class pairSumSortedRotated {
    // brute force approach - not optimal solution
    // time complexity -> O(n^3 log n)
    public static boolean pairSumSortedRotated1 (int nums[], int x) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            int sum = 0;
            for(int j=i+1;j<nums.length; j++) {
                sum = nums[i] + nums[j];
                if(sum == x) {
                    return true;
                }
            }
        }
        return false;
    } 
    
    public static void main(String[] args) {
        int nums[] = {11, 15, 6, 8, 9, 10}, X = 16;
        System.out.println(pairSumSortedRotated1(nums, X));
    }
}