public class minSortedRotated {
    // brute force approach - not optimal solution
    // time complexity -> O(n);
    public static int MinimumEleSortedRotated(int nums[]) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    // optimal solution using binary search
    // time complexity -> O(log n)
    public static int MinimumEleSortedRotated2 (int nums[]) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length - 1;
        while (start<=end) {
            int mid = ( start + end ) / 2;
            if(nums[start]<=nums[mid]) {
                min = Math.min(nums[start], min);
                start = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                end = mid - 1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int nums[] = {4, 5};
        System.out.println(MinimumEleSortedRotated2(nums));
    }
}
