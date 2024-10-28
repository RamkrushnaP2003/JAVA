public class LongestSubArrSumAtmostK {
    public static int longestSubArrSumAtmostK(int nums[], int k) {
        int maxLength = 0;
        for(int i=0; i<nums.length; i++) {
            // int count = 0;
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                if(sum > k) {
                    break;
                } else {
                    // count++;
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int nums[] = {8, 3, 5, 4, 1, 7};
        int k = 10;
        System.out.println(longestSubArrSumAtmostK(nums, k));
    }
}