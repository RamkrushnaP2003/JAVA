import java.util.*;;

public class Permutation {
    // time complexity -> O(n * n!)
    public static void permutation(String str, StringBuilder newStr, boolean[] freq) {
        if(str.length() == newStr.length()) {
            System.out.println(newStr);
            return;
        }
        for(int i=0; i<str.length(); i++) {
            if(!freq[i]){
                freq[i] = true;
                char curr = str.charAt(i);
                newStr.append(curr);
                permutation(str, newStr, freq);
                newStr.deleteCharAt(newStr.length()-1);
                freq[i]= false;
            }
        }
    }

    public static void permutation2(int nums[], ArrayList<Integer> list , boolean[] freq) {
        if(nums.length == list.size()) {
            System.out.println(list);
            return;
        }  
        for(int i=0; i<nums.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                list.add(nums[i]);
                permutation2(nums,  list, freq);
                list.remove(list.size()-1);
                freq[i] = false;
            }
        }
    }

    public static void permutation3(int nums[], ArrayList<Integer> list) {
        if(nums.length == list.size()) {
            System.out.println(list);
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
                permutation3(nums, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        // String str = "abc";
        // permutation(str, new StringBuilder(), new boolean[str.length()]);
        int nums[] = {1, 2, 3};
        // permutation2(nums, new ArrayList<>(), new boolean[nums.length]);
        permutation3(nums, new ArrayList<>());
    }
}
