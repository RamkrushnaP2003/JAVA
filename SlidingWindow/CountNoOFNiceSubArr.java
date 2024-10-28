// sub arr is nice if it contain k odd element

public class CountNoOFNiceSubArr {
    public static int countniceSubArr(int nums[], int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int oddCount = 0;
            for(int j=i; j<nums.length; j++) {
                if(nums[j] % 2 != 0) oddCount++;
                if(oddCount == k) count++;
                if(oddCount > k) break;
            }
        }
        return count;
    }

    public static int countniceSubArr2(int nums[], int k) {
        int count = 0, l=0, r=0, sum=0;
        while (r<nums.length) {
            sum += nums[r]%2;
            while(sum > k) {
                sum -= nums[l++]%2;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 2, 1, 1}, k=2;
        System.out.println(countniceSubArr(nums, k));
        System.out.println(countniceSubArr2(nums, k));
        System.out.println(countniceSubArr2(nums, k-1));
        System.out.println(countniceSubArr2(nums, k)-countniceSubArr2(nums, k-1));
    }
}
