import java.util.Arrays;

public class MergeSortedArray {
    public static void mergeSortedArray(int nums1[], int nums2[], int n, int m) {
        int nums3[] = new int[n+m];
        int i=0, j=0, k=0;
        while (i<n && j<m) {
            if(nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        while (i<n) {
            nums3[k++] = nums1[i++];
        } 
        while (j<m) {
            nums3[k++] = nums2[j++];
        }
        for(i=0; i<nums3.length; i++) {
            System.out.print(nums3[i]+" ");
        }
    }

    public static void mergeSortedArray2(int nums1[], int nums2[], int n, int m) {
        int left = n - 1;
        int right = 0;
        while (left >= 0 && right < m) {
            if (nums1[left] > nums2[right]) {
                swap(nums1, nums2, left, right);
                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    public static void swap(int nums1[], int nums2[], int i, int j) {
        if(nums1[i] > nums2[j]) {
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
        }
    }

    public static void mergeSortedArray3(int nums1[], int nums2[], int n, int m) {
        int len = n+m;
        int gap = (len/2) + (len%2);
        while (gap > 0) {
            int left = 0;
            int right = gap;
            while (right < len) {
                // nums1 and nums2
                if(left < n && right>=n) {
                    // if(nums1[left] > nums2[right-n]) {
                    //     int temp = nums1[left];
                    //     nums1[left] = nums2[right-n];
                    //     nums2[right-n] = temp;
                    // }
                    swap(nums1, nums2, left, right-n);
                } // nums2 and nums2
                else if(left >= n) {
                    // if(nums2[left-n] > nums2[right-n]) {
                    //     int temp = nums2[left-n];
                    //     nums2[left-n] = nums2[right-n];
                    //     nums2[right-n] = temp;
                    // }
                    swap(nums2, nums2, left-n, right-n);
                } // nums1 and nums1
                else {
                    // if(nums1[left] > nums1[right]) {
                    //     int temp = nums1[left];
                    //     nums1[left] = nums1[right];
                    //     nums1[right] = temp;
                    // }
                    swap(nums1, nums1, left, right);
                }
                left++;right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }

    public static void main(String[] args) {
        int nums1[] = {0, 3, 6, 9};
        int nums2[] = {1, 2, 4, 5, 7, 10};
        int n = nums1.length, m = nums2.length;
        mergeSortedArray2(nums1,nums2,n, m);
        for(int i=0; i<nums1.length; i++) {
            System.out.print(nums1[i]+" ");
        }
        for(int i=0; i<nums2.length; i++) {
            System.out.print(nums2[i]+" ");
        }
        System.out.println();
        mergeSortedArray3(nums1, nums2, n, m);
        for(int i=0; i<nums1.length; i++) {
            System.out.print(nums1[i]+" ");
        }
        for(int i=0; i<nums2.length; i++) {
            System.out.print(nums2[i]+" ");
        }
        System.out.println();
        mergeSortedArray(nums1, nums2, n, m);
    }
}
