import java.util.*;

public class TwoSum {
    public static void twoSum(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        Set<Integer> keys = map.keySet();
        for(Integer key : keys) {
            int diff = target - key;
            if(map.containsKey(diff)) {
                System.out.println(map.get(key)+", "+map.get(diff));
                return;
            }
        }
    }
        
    public static void twoSum2(int nums[], int target) {
        int ans[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                ans[0] = map.get(diff);
                ans[1] = i;
            }
            map.put(nums[i], i);
        }
        System.out.println(ans[0]+", "+ans[1]);
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4 ,5, 6, 7, 8, 9};
        int target = 11;
        twoSum(nums, target);
        twoSum2(nums, target);
    }
}
