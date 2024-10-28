public class maxSubArrayProduct {
    // brute force approach 
    // time complexity -> O(n^3)
    public static int maxSubArrayProduct1(int nums[]) {
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                int product = 1;
                for(int k=i; k<=j; k++) {
                    product *= nums[k];
                    maxProduct = Math.max(product,maxProduct);
                }
            }
        }
        return maxProduct;
    }

    // Not optimal but better than above solution
    // time complexity -> O(n^2)
    public static int maxSubArrayProduct2(int nums[]) {
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            int product = 1;
            for(int j=i; j<nums.length; j++) {
                product *= nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }

    // Optimal solution using prefix and suffix
    // time complexity -> O(n)
    public static int maxSubArrayProduct3(int nums[]) {
        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(prefix == 0 ) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[nums.length-1-i];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int nums[] = {-3, -1, -1};
        System.out.println(maxSubArrayProduct1(nums));
        System.out.println(maxSubArrayProduct2(nums));
        System.out.println(maxSubArrayProduct3(nums));
    }
}
