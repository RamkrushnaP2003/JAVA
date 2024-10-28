import java.util.*;

public class Subset {
    // time complexity -> O(2^n)
    // space complexity -> O(n)
    public static void subset1(String str, int i, StringBuilder sb) {
        if(str.length() == i) {
            System.out.println(sb);
            return;
        }
        sb.append(str.charAt(i));
        subset1(str, i+1, sb);
        sb.deleteCharAt(sb.length()-1);
        subset1(str, i+1, sb);
    }

    public static void subset2(String str, String newStr, int i) {
        if(str.length() == i) {
            if(newStr.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(newStr);
            }
            return;
        }
        subset2(str, newStr+str.charAt(i), i+1);
        subset2(str, newStr, i+1);
    }

    // for integer array
    public static void subset3(int nums[], int i, List<List<Integer>> list, List<Integer> value) {
        if(i == nums.length) {
            list.add(new ArrayList<>(value));
            return;
        }
        value.add(nums[i]);
        subset3(nums, i+1, list, value);
        value.remove(value.size()-1);
        subset3(nums, i+1, list, value);
    }

    public static void main(String[] args) {
        // String str = "ab";
        // subset2(str, "", 0);
        int nums[] = {1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        subset3(nums, 0, list, value);
        System.out.println(list);
    }
}
