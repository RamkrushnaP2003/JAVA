import java.util.HashMap;

public class SlidingWindowMaxSum {
    /* LeetCode
    2461. Maximum Sum of Distinct Subarrays With Length K

     You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

        - The length of the subarray is k, and
        - All the elements of the subarray are distinct.

    Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

    A subarray is a contiguous non-empty sequence of elements within an array.
    */

    // time complexity -> O(n * k) // not optimal 
    public static int maxSubArrSum(int nums[], int k){
        int n = nums.length;
        int maxSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n-k+1; i++) {
            int sum = 0;
            for(int j=i; j<i+k; j++) {
                if(map.containsKey(nums[j])) {
                    break;
                } else {
                    map.put(nums[j], i);
                }
            }
            if(map.size() != k) {
                map.clear();
                continue;
            }
            for(Integer key : map.keySet()) {
                sum += key;
            }
            maxSum = Math.max(sum, maxSum);
            map.clear();
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 4, 2, 9, 9, 9};
        System.out.println(maxSubArrSum(nums, 3));
    }
}
