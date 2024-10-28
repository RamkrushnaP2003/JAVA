import java.util.HashMap;

public class LargestSubArrSumZero {
    public static int largestSubArr(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int length = 0;
        int start=0, end=0;
        for(int j=0; j<nums.length; j++) {
            sum += nums[j];
            if(map.containsKey(sum)) {
                if(length < (j-map.get(sum))) {
                    length = (j-map.get(sum));
                    start = map.get(sum)+1;
                    end = j;
                }
            } else {
                map.put(sum, j);
            }
        }
        for(int i=start; i<=end; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return length;
    }

    public static void main(String[] args) {
        int nums[] = {15, -2, 2, -8, 1, 7};
        // largestSubArr(nums);
        // System.out.println();
        System.out.println(largestSubArr(nums));
    }
}
