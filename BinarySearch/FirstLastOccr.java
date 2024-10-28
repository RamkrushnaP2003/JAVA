public class FirstLastOccr {
    public static int lowerBound(int nums[], int n, int x) {
        int low = 0, high = n-1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] == x) {
                ans = mid;
                high = mid - 1;
            } else if(nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBoud(int nums[], int n, int x) {
        int low = 0, high = n-1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == x) {
                ans = mid;
                low = mid + 1;
            } else if(nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // time complexity -> O(2 log n)
    // space complexity -> O(1])
    public static void pair(int nums[], int x) {
        int lb =  lowerBound(nums, nums.length, x);
        int up = upperBoud(nums, nums.length, x);
        // if(lb == nums.length || nums[lb] != 77) System.out.println("Not found");
        System.out.println(lb+", "+(up));
    }

    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};
        int x = 8;
        pair(nums, x);
    }
}