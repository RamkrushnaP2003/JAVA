public class maximumSubArraySum {
    // Brute force approach and not optimal solution
    // time complexity = O(n^3)
    // space complexity = O(1) -> no use of Auxillary Array
    public static int maxSubArraySum1(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum=0;
                for(int k=i; k<=j; k++) {
                    sum = sum + arr[k];
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }

    // Brute force approach and optimal than 1st solution
    // time complexity = O(n^2)
    // space complexity = O(1) -> no use of Auxillary Array
    public static int maximumSubArraySum2(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            int sum=0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // kadane's Algorithm -> optimal solution for maxSubArraySum
    // time complexity = O(n)
    // space complexity = O(1)
    public static int maximumSubArraySum3(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if( sum < 0 ) {
                sum = 0;
            } 
        }
        if(sum == 0) {
            return -1;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int nums1[] = {-1, -2, -3, -4};
        System.out.println(maxSubArraySum1(nums));
        System.out.println(maximumSubArraySum2(nums));
        System.out.println(maximumSubArraySum3(nums1));
    }
}
