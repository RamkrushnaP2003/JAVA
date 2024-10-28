import java.util.HashMap;

public class SubArrSumEqualK {
    public static int subArrSumEqualK(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for(int j=0; j<nums.length; j++) {
            sum += nums[j];
            if(map.containsKey(sum - k)) {
                count += map.get(sum-k);
            } 
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
    
    public static void main(String[] args) {
        int nums[] = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(subArrSumEqualK(nums, k));
    }
}
