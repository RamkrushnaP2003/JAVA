public class threeSum {
    public static void ThreeSum (int nums[]) {
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i]+nums[k]+nums[j]==0 && i!=j && i!=k && k!=j) {
                        System.out.println(nums[i]+"+"+nums[j]+"+"+nums[k]+"+"+" = 0");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -1};
        ThreeSum(nums);
    }
}
