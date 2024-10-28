import java.util.*;

public class Subset_II {
    public static void subset(int nums[], int idx, HashSet<List<Integer>> map, List<List<Integer>> ans, List<Integer> set) {
        if(idx == nums.length) {
            if(map.contains(set)) {
                return;
            } else {
                map.add(new ArrayList<>(set));
                ans.add(new ArrayList<>(set));
                return;
            }
        }
        set.add(nums[idx]);
        subset(nums, idx+1, map, ans, set);
        set.remove(set.size()-1);
        // while(idx+1 < nums.length && nums[idx] == nums[idx+1]) idx++;
        subset(nums, idx+1, map, ans, set);
    }

    public static void main(String[] args) {
        int nums[] = {4,4,4,1,4};
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums, 0, new HashSet<>(), ans, new ArrayList<>());
        System.out.println(ans);
    }
}