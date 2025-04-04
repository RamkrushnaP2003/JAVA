import java.util.*;

public class LonelyNumber {
    public static void lonelyNo(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<nums.size()-1; i++) {
            if(nums.get(i-1)+1 < nums.get(i) && nums.get(i)+1 < nums.get(i+1)) {
                list.add(nums.get(i));
            }
        }
        if(nums.size() == 1) {
            list.add(0);
        }
        if(nums.size() > 1) {
            if(nums.get(0)+1 < nums.get(1)) {
                list.add(nums.get(0));
            }
            if(nums.get(nums.size() - 2) +1 < nums.get(nums.size()-1))  {
                list.add(nums.get(nums.size()-1));
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(6);
        nums.add(5);
        nums.add(8);
        // lonelyNo(nums);
        System.out.println(nums.get(2)+1<nums.get(2));
    }
}