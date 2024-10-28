public class MissingNumber {
    public static int missingNumber(int nums[]) {
        int n = nums.length;
        // int ans[] = new int[n+1];
        boolean isValid[] = new boolean[n+1];
        // for(int i=0; i<ans.length; i++) {
        //     ans[i] = i;
        // }
        for(int i=0; i<n; i++) {
            isValid[nums[i]] = true;
        }
        for(int i=0; i<n+1; i++) {
            if(!isValid[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }
}
