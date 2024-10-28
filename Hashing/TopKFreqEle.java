import java.util.*;

public class TopKFreqEle {
    static class Pair {
        int num=0, freq=0;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public static void topKFrequent(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(int key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }
        for(int i=0; i<k; i++) {
            System.out.print(pq.remove().num+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3};
        int k=2;
        topKFrequent(nums, k);
    }
}
