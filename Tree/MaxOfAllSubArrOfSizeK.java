import java.util.*;

public class MaxOfAllSubArrOfSizeK {
    static class Pair implements Comparable<Pair> {
        int val, idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }

    public static void slidingWindow(int window[], int k) {
        int n = window.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((b, a) -> a.val - b.val);
        int res[] = new int[n-k+1];
        for(int i=0; i<k; i++) {
            pq.add(new Pair(window[i], i));
        }
        res[0] = pq.peek().val;
        for(int i=k; i<n; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i-k)) {
                pq.remove();
            }
            pq.add(new Pair(window[i], i));
            res[i-k+1] = pq.peek().val;
        }
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    // time complexity -> O(n*k)
    public static void slidingWindow2(int window[], int k) {
        int n = window.length;
        int res[] = new int[n-k+1];
        int x=0;
        for(int i=0; i<n-k+1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=i; j<i+k; j++) {
                max = Math.max(max, window[j]);
            }
            res[x++] = max;
        }
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    public static void main(String[] args) {
        int window[] = {1, 3, -1, -3, 5, 3, -6, -7};
        // int window[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;
        slidingWindow2(window, k);
        System.out.println();
        System.out.println();
    }
}
