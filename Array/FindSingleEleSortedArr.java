public class FindSingleEleSortedArr {
    public static int singleEle(int nums[]) {
        int n=nums.length;
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        for(int i=1; i<n-1; i++) {
            if(nums[i-1] != nums[i] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // [even, odd] -> Element is on right half
    // [odd, even] -> Element is on left half
    public static int singleEle2(int nums[]) {
        int n=nums.length;
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        int left = 1, right = n-2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) {
                return nums[mid];
            }
            if(((mid%2!=0) && nums[mid-1] == nums[mid]) || ((mid%2 == 0) && (nums[mid] == nums[mid+1]))) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(singleEle(nums));
    }
}
