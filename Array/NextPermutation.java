public class NextPermutation {
    public static void nextPermutation(int nums[]) {
        int n = nums.length;
        int idx = -1;
        for(int i=n-2; i>=0; i--) {
            if(nums[i+1] > nums[i]) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            reverse(nums, 0, n-1);
            return;
        }
        for(int i=n-1; i>idx; i--) {
            if(nums[i] > nums[idx]) {
                swap(nums, idx, i);
                break;
            }
        }
        reverse(nums, idx+1, n-1);
        return;
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int nums[], int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int nums[] = {3, 6, 2, 6, 2, 6, 2345};
        nextPermutation(nums);
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}