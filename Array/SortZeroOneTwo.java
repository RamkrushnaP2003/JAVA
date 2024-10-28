public class SortZeroOneTwo {
    public static void sortColors(int nums[]) {
        int n = nums.length;
        int z=0, o=0, t=0;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) z++;
            else if (nums[i] == 1) o++;
            else t++;
        }
        int ans[] = new int[n];
        int p=0;
        int q=z;
        int r=o+z;

        for(int i=0; i<n; i++) {
            if(nums[i]==0) {
                ans[p++] = 0;
            } else if (nums[i]==1) {
                ans[q++] = 1;
            } else {
                ans[r++] = 2;
            }
        }
        for(int i=0; i<n; i++) {
            nums[i] = ans[i];
        }
    }

    public static void sortColors2(int nums[]) {
        int n = nums.length;    
        int countZero = 0, countOne = 0, countTwo = 0;
        for(int i=0; i<n; i++) {
            if(nums[i]==0) countZero++;
            else if (nums[i] == 1) countOne++;
            else countTwo++;
        }
        for(int i=0; i<countZero; i++) nums[i] = 0;
        for(int i=countZero; i<countOne+countZero; i++) nums[i] = 1;
        for(int i=countZero+countOne; i<n; i++) nums[i] = 2;
    }

    public static void DNF(int nums[]) {
        int n=nums.length;
        int left=0, mid=0, right=n-1;
        // while(mid<=right) {
        //     if(nums[mid] == 0) {
        //         swap(nums, left, mid);
        //         mid++;
        //         left++;
        //     } else if (nums[mid] == 1) {
        //         mid++;
        //     } else {
        //         swap(nums, mid, right);
        //         right--;
        //     }
        // }
        while(mid <= right) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, mid, left);
                    mid++;
                    left++;
                    break;
                case 1:
                    mid++;
                case 2:
                    swap(nums, mid, right);
                    right--;
            }
        }
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        DNF(nums);
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
