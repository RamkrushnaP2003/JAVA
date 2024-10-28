import java.util.*;

public class LastStoneWt {
    public static int lastStoneWeight(int stones[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stoneWt : stones) {
            pq.add(stoneWt);
        }
        while (pq.size() != 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            pq.offer(stone1 - stone2);
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int stones[] = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }
}
