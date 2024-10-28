import java.util.*;

public class SubArrWithKDiffInteger {
    public static int subArrWithDiffKInt(int nums[], int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            // if(nums.length - k - 1 == i) break;
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<nums.length; j++) {
                set.add(nums[j]);
                if(set.size() == k) {
                    count++;
                } 
                
                else if(set.size() > k) break;
            }
        }
        return count;
    }

    public static int countSubArrWithKDiffInt(int nums[], int k) {
        int count=0, l=0, r=0; 
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,1,2,3}, k=2;
        // System.out.println(subArrWithDiffKInt(nums, k));
        System.out.println(countSubArrWithKDiffInt(nums, k)-countSubArrWithKDiffInt(nums, k-1));
    }
}
