import java.util.*;

public class MajorityElement {
    public static void majorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            // if(map.containsKey(num)) {
            //     map.put(num, map.get(num)+1);
            // } else {
            //     map.put(num, 1);
            // }
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        // Set<Integer> keys = map.keySet();
        for(Integer key : map.keySet()) {
            if(map.get(key) > nums.length/3) {
                System.out.println(key);
            }
        }

    }

    public static void main(String[] args) {
        int nums[] = {1, 2};
        majorityElement(nums);
    }
}
