public class BSFirstLastOccr {
    public static void BS(int nums[], int target) {
        int start = 0;
        int end = nums.length-1;
        boolean checkStart = false;
        boolean checkEnd = false;
        while (start <= end) {
            if(nums[start] == target && !checkStart) checkStart = true;
            if(nums[end] == target && !checkEnd) checkEnd = true;
            if(nums[start] < target) start++;
            if (nums[end] > target) end--;
            if(checkEnd && checkStart) {
                System.out.println(start+", "+end);
                return;
            }
        }
        System.out.println("["+ (-1) + ", " + (-1) + "]");
    }

    public static void main(String[] args) {
        int nums[] = { 6, 7, 7, 9, 9};
        BS(nums, 7);
    }
}
