import java.util.ArrayList;

public class MonotonicArrayList {
    public static boolean monotonic(ArrayList<Integer> nums) {
        if(nums.get(0) < nums.get(nums.size()-1)) {
            for(int i=0; i<nums.size()-1; i++) {
                if(nums.get(i) > nums.get(i+1)) {
                    return false;
                }
            }
        } else {
            for(int i=0; i<nums.size()-1; i++) {
                if(nums.get(i) < nums.get(i+1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean monotonic2(ArrayList<Integer> nums) {
        boolean inc = true;
        boolean dec = true;
        for(int i=0; i<nums.size()-1; i++) {
            if(nums.get(i) > nums.get(i+1)) {
                inc = false;
            }
            if(nums.get(i) < nums.get(i+1)) {
                dec = false;
            }
        }
        return inc || dec;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(6);
        nums.add(5);
        nums.add(4);
        nums.add(4);
        System.out.println(monotonic2(nums));;
    }
}
