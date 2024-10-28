public class MoveZeroEnd {
    public static void moveZerosEnd(int nums[]) {
        int z = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[z++] = nums[i];
            }
        }
        for(int i=z; i<nums.length; i++) {
            nums[i] = 0;
        }
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        moveZerosEnd(nums);
    }
}
