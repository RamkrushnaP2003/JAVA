public class CountSubArrSumEqualK {
    public static int subArrSum(int nums[], int k) {
        int n=nums.length;
        int count = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += nums[j];
                if(sum == k) count++;
            }
        } 
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1};
        int k=2;
        System.out.println(subArrSum(nums, k));
    }
}