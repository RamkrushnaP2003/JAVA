import java.util.*;

public class ConnectNRopes {
    public static int minostToConnectRopes(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while(pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += (min1+min2);
            pq.add(min1+min2);
        }
        return cost;
    }

    public static void main(String[] args) {
        int ropes[] = {2, 3, 4, 6};
        System.out.println(minostToConnectRopes(ropes));
    }
}
