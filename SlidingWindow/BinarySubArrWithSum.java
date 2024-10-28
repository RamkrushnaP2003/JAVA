import java.util.*;

public class BinarySubArrWithSum {
    public static int countSubArr(int nums[], int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                } else if(sum > k) {
                    break;
                }
            }
        }
        return count;
    }

    public static int countSubArr2(int nums[], int k) {
        int count = 0, sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static int maxSubArrSumK(int nums[], int k) {
        if(k < 0) return 0;
        int l=0, r=0, sum=0, count=0;
        while(r<nums.length) {
            sum += nums[r];
            while(sum > k) {
                sum -= nums[l];
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {0, 0, 0, 0, 0};
        int k=0;
        System.out.println(countSubArr(nums,k));
        System.out.println(countSubArr2(nums, k));
        System.out.println(maxSubArrSumK(nums, k)-maxSubArrSumK(nums,k-1));
    }
}
