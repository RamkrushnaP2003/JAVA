import java.util.*;

public class NextGreater {
    // brute force approach
    // time complexity -> O(n^2)
    // space complexity -> O(1)
    public static void nextGreater(int nums[]){
        for(int i=0; i<nums.length; i++) {
            int nextGraterEle = -1;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]<nums[j] && nextGraterEle == -1) {
                    nextGraterEle = nums[j];
                }
            }
            nums[i] = nextGraterEle;
        }
    }

    // int while loop the time is taken by O(2n) and outer loop O(n) = O(3n)
    // time complexity -> O(n)
    public static void nextGraterEle2(int nums[]) {
        Stack<Integer> s = new Stack<>();
        int nextGraterEles[] = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--) {
            while(!s.empty() && nums[s.peek()] <= nums[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextGraterEles[i] = -1;
            } else {
                nextGraterEles[i] = nums[s.peek()];
            }
            s.push(i);
        }
        for(int i=0; i<nextGraterEles.length; i++) {
            System.out.print(nextGraterEles[i]+" ");
        }
    }

    public static void main(String[] args) {
        int nums[] = {6, 8, 0, 1, 3};
        nextGraterEle2(nums);
        System.out.println();
        // next greater right
        // next greater left
        // next smaller right
        // next smaller left
    }
}
