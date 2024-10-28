import java.util.*;

public class SingleNumber {
    public static int singleNumber(int nums[]) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            if(count == 1) return nums[i];
        }
        return 0;
    }

    public static int singleNumber2(int nums[]) {
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static int singleNumber3(int nums[]) {
        int n = nums.length;
        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(!ans1.contains(nums[i])) {
                ans1.add(nums[i]);
            } else {
                ans2.add(nums[i]);
            }
        }
        for(int i=0; i<ans1.size()-1; i++) {
            if(!ans2.contains(ans1.get(i))) {
                return ans1.get(i);
            }
        }
        return ans1.get(ans1.size()-1);
    }

    public static void main(String[] args) {
        int nums[] = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}