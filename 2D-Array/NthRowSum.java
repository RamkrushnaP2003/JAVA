public class NthRowSum {
    public static int NthRowSum1 (int nums[][], int row) {
        int n = nums.length;
        int m = nums[0].length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i == row-1) {
                    sum += nums[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[][] = {{1, 4, 9}, {11, 4, 3}, {2, 2, 3}};
        System.out.println(NthRowSum1(nums, 2));
    }
}
