import java.util.*;

public class NoOfSubArrSumEqualK {
  public static int noOfSubArrSumEqK(int nums[], int k) {
    int count=0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    for(int i=0; i<nums.length; i++) {
      sum += nums[i];
      if(map.containsKey(sum-k)) {
        count += map.get(sum-k);
        // System.out.println(count);
      }
      map.put(sum, map.getOrDefault(sum, 0)+1);
    }
    // fop
    return count;
  }

  public static void main(String[] args) {
    int nums[] = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
    int k=3;
    System.out.println(noOfSubArrSumEqK(nums, k));
  }
}
