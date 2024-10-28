import java.util.*;

public class FruitAndBasket {
    // time complexity -> O(2n)
    // Space complexity -> O(3) constant
    public static int maxFruits(int nums[]) {
        int l=0, r=0, maxFruits=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            if(map.size() <= 2) {
                maxFruits = Math.max(maxFruits, r-l+1);
            }
            while (map.size() > 2) {
                if(map.get(nums[l]) == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], map.getOrDefault(nums[l], 0)-1);
                }
                l++;
            }
            r++;
        }
        return maxFruits;
    }

    // time complexity -> O(n)
    // space complexity -> O(3) = constant
    public static int maxFruits2(int nums[]) {
        int l=0, r=0, maxFruits=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            if(map.size() > 2) {
                if(map.get(nums[l]) == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], map.getOrDefault(nums[l], 0)-1);
                }
                l++;
            }
            if(map.size() <= 2) {
                maxFruits = Math.max(maxFruits, r-l+1);
            }
            r++;
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int nums[] = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(maxFruits(nums));
        System.out.println(maxFruits2(nums));
    }
}
