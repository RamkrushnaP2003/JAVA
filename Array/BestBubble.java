import java.util.Arrays;

public class BestBubble {
  public static int bstBubble(int arr[], boolean ascending) {
    int n=arr.length;
    int nums[] = Arrays.copyOf(arr, n);
    int count = 0;
    for(int i=0; i<n-1; i++) {
      for(int j=0; j<(n-i-1); j++) {
        if(ascending) {
          if(nums[j] > nums[j+1]) {
            swap(nums, j, j+1);
            count++;
          }
        } else {
          if(nums[j] < nums[j+1]) {
            swap(nums, j, j+1);
            count++;
          }
        }
      }
    }
    return count;
  }

  public static void swap(int nums[], int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    int nums[] = {4, 5, 3, 2, 1};
    System.out.println(Math.min(bstBubble(nums, true), bstBubble(nums, false)));    
    // System.out.println();
  }
}