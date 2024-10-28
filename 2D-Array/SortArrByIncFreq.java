import java.util.*;

public class SortArrByIncFreq {
    static class Pair implements Comparable<Pair>{
        int num, freq;
        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair p2) {
            if(this.freq == p2.freq) {
                return p2.num - this.num;
            } else {
                return this.freq - p2.freq;
            }
        }
    }

    public static void incFreqOrder(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }
        int idx = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            for(int i=0; i<curr.freq; i++) {
                nums[idx++] = curr.num;
            }
        }
        for(int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int nums[] = {8,-8,2,-8,-5,-3};
        incFreqOrder(nums);
    }
}