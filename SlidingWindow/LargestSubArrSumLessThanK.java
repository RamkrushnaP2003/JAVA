public class LargestSubArrSumLessThanK {
    public static int largestSubArrSumLessThanK(int nums[], int k) {
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                if(sum > k) {
                    break;
                } else {
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }

    public static int largestSubArrSumLessThanKOpt(int nums[], int k) {
        int l=0, r=0, sum=0, maxLen = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > k) {
                sum -= nums[l];
                l++;
            }
            if(sum <= k) {
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String args[]) {
        int nums[] = {2, 5, 1, 7, 10};
        System.out.println(largestSubArrSumLessThanKOpt(nums, 15));
    }
}