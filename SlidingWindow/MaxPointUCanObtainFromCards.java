public class MaxPointUCanObtainFromCards {
    public static int maxScore(int nums[], int k) {
        int sum = 0, lsum = 0, rsum = 0;
        for(int i=0; i<k; i++) {
            lsum += nums[i];
        }
        sum = lsum;
        int ridx = nums.length-1;
        for(int i=k-1; i>=0; i--) {
            lsum -= nums[i];
            rsum += nums[ridx--];
            sum = Math.max(sum, lsum + rsum);
        }

        return sum;
    }

    public static void main(String[] args) {
        int nums[] = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        int k = 4;
        System.out.println(maxScore(nums, k));
    }
}
