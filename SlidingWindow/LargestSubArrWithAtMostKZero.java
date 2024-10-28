public class LargestSubArrWithAtMostKZero {
    public static int longestOnes(int nums[], int k) {
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            int count = 0;
            for(int j=i; j<nums.length; j++) {
                if(nums[j] == 0) count++;
                if(k < count) break;
                max = Math.max(max, j-i+1);
            }
        }
        return max;
    }

    public static int longestOnes2(int nums[], int k) {
        int l=0, r=0, z=0, maxLen=0;
        while(r < nums.length) {
            if(nums[r] == 0) z++;
            while(z > k) {
                if(nums[l] == 0) z--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }

    public static int longestOnes3(int nums[], int k) {
        int l=0, r=0, z=0, maxLen=0;
        while(r < nums.length) {
            if(nums[r] == 0) z++;
            if(z > k) {
                if(nums[l] == 0) z--;
                l++;
            }
            if(z <= k) {
                maxLen = Math.max(maxLen, r-l+1);
            }r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0}, k = 2;
        System.out.println(longestOnes(nums, k));
        System.out.println(longestOnes2(nums, k));
        System.out.println(longestOnes3(nums, k));
    }
}