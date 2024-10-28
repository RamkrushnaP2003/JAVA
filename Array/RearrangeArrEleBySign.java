import java.util.ArrayList;

public class RearrangeArrEleBySign {
    // not optimal 
    // time complexity -> O(n)
    // space complexity -> O(n)
    public static void rearrangeArray(int nums[]) {
        int newArr[] = new int[nums.length];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }
        int j=0;
        for(int i=0; i<pos.size(); i++) {
            newArr[j++] = pos.get(i);
            newArr[j++] = neg.get(i);
        }
        for(int i=0; i<nums.length; i++) {
            System.out.print(newArr[i]+" ");
        }
        System.out.println();
    }

    public static void rearrangeArray2(int nums[]) {
        int pos[] = new int[nums.length/2];
        int neg[] = new int[nums.length/2];
        int posI=0;
        int negI=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= 0) {
                pos[posI++] = nums[i];
            } else {
                neg[negI++] = nums[i];
            }
        }
        int j=0;
        for(int i=0; i<pos.length; i++) {
            nums[j++] = pos[i];
            nums[j++] = neg[i];
        }
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    // optimal solution
    // time complexity -> O(n)
    // space complexity -> O(1)
    public static void rearrangeArray3(int nums[]) {
        int ans[] = new int[nums.length];
        int pos=0, neg=1;
        for(int ele : nums) {
            if(ele >= 0) {
                ans[pos] = ele;
                pos+=2;
            } else {
                ans[neg] = ele;
                neg+=2;
            }
        }
        for (int ele : ans) {
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {3, 1, -2, -5, 2, -4};
        rearrangeArray2(nums);
    }
}
