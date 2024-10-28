import java.util.*;

public class KMaxAndMinEle {
    public static int KLargestEle(int nums[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            pq.offer(nums[i]);
        }
        for(int i=k; i<nums.length; i++) {
            if(pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
    
    public static int KSmallEle(int nums[], int k) {  
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<k; i++) {
            pq.offer(nums[i]);
        }
        for(int i=k; i<nums.length; i++) {
            if(pq.peek() > nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String args[]) {
        int nums[] = {20, 10, 60, 30, 50, 40}; 
        // {10, 20, 30, 40, 50, 60} pq = {40} kthLargestEle  = 40
        // {60, 50, 40, 30 ,20, 10} KthSmallestELe = 30
        int k=3;
        System.out.println(KLargestEle(nums, k));
        System.out.println(KSmallEle(nums, k));
    }
}









About
change skill
Description
Detailed Quote

Footer 
social media links

Images
Accourding myself
