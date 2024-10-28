import java.util.ArrayList;

public class CombinationSum {
    // time complexity -> O(2^t * k) t = target & k = length of recursion tree
    // space complexity -> O(k * x)
    public static void combSum(int candidates[], int i, int target, ArrayList<ArrayList<Integer>> ans,
            ArrayList<Integer> value) {
        if (i == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(value));
            }
            return;
        }
        if (candidates[i] <= target) {
            value.add(candidates[i]);
            combSum(candidates, i, target - candidates[i], ans, value);
            value.remove(value.size() - 1);
        }
        combSum(candidates, i + 1, target, ans, value);
    }

    public static void main(String[] args) {
        int candidates[] = { 2, 3, 6, 7 };
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        combSum(candidates, 0, 7, ans, new ArrayList<>());
        System.out.println(ans);
    }
}