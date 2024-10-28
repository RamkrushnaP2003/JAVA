import java.util.ArrayList;

public class RemoveDuplFromSortArr {
    public static void removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != list.get(list.size()-1)) {
                list.add(nums[i]);
            }
        }
        System.out.println(list+" -> "+list.size());
    }

    public static void removeDuplicates2(int[] nums)  {
        int j=1;
        for(int i=1; i<nums.length; i++) {
            if(nums[j-1] != nums[i]) {
                nums[j++] = nums[i];
            }
        }
        for(int i=0; i<j; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 4, 4};
        removeDuplicates2(nums);
    }
}
