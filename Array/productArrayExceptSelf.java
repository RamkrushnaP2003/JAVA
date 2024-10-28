public class productArrayExceptSelf {
    // brute force approach not optimal
    // time complexity -> O(n^2)
    // space complexity -> O(1)
    public static void ProductArrayExceptSelf (int nums[]) {
        for(int i=0; i<nums.length; i++) {
            int prefix = 1;
            for(int j=0; j<nums.length; j++) {
                if(i != j) {
                    prefix *= nums[j];
                }
            }
            System.out.print(prefix+" ");
        }
    }

    // optimal approach
    // time complexity -> O(n)
    // space complexity -> O(n)// using auxillary array it will take extra space
    public static void ProductArrayExceptSelf2(int nums[]) {
        int left[] = new int[nums.length];
        left[0] = 1;
        for(int i=1; i<nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        
        int right[] = new int[nums.length];
        right[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i=0; i<nums.length; i++) {
            System.out.print((nums[i]=left[i]*right[i])+" ");
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        ProductArrayExceptSelf2(nums);
    }
}
