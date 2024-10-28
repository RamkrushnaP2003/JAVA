public class SquareOfSortedArray {
    // public static int ans[];
    public static int[] sortedSquares(int nums[]) {
        int n = nums.length;
        int[] ans = new int[n];
        int left=0, right=n-1;
        int curr = n-1;
        while(left<=right) {
            int first = nums[left] * nums[left];
            int last = nums[right] * nums[right];
            if(first < last) {
                ans[curr--] = last;
                right--;
            } else {
                ans[curr--] = first;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {-7,-3,2,3,11};
        int[] ans = sortedSquares(nums);
        for(int i=0; i<sortedSquares(nums).length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
