import java.util.*;

public class NearByCars {
    // static class Point implements Comparable<Point>{
    static class Point {
        int x;
        int y;
        int dstSqr;
        int idx;

        public Point(int x, int y, int dstSqr, int idx) {
            this.x = x;
            this.y = y;
            this.dstSqr = dstSqr;
            this.idx = idx;
        }

        // @Override
        // public int compareTo(Point p2) {
        //     return this.dstSqr - p2.dstSqr;
        // }
    }

    public static void main(String[] args) {
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        
        Arrays.sort(pts, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        for(int i=0; i<k; i++) {
            System.out.println(pts[i][0]+", "+pts[i][1]);
        }

        // using priority Queue
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.dstSqr - b.dstSqr);
        for(int i=0; i<pts.length; i++) {
            int dstSqr = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], dstSqr, i));
        }
        for(int i=0; i<k; i++) {
            System.out.println("C"+pq.peek().idx);
            pq.remove();
        }
    }
}