import java.util.*;

public class CheapestFlightWithinKStop {
    static class Edge {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair {
        int v, cost, stop;
        public Pair(int v, int cost, int stop) {
            this.v = v;
            this.cost = cost;
            this.stop = stop;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];
            Edge e = new Edge(src, dest, cost);
            graph[flights[i][0]].add(e);
        }
    }

    public static int cheapestFlight(int[][] flights, int src, int dest, int k) {
        int n = flights.length;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for(int i=0; i<n; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if(curr.stop > k) break;
            for(int i=0; i<graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                if(dist[e.src] != Integer.MAX_VALUE && curr.cost + e.wt < dist[e.dest] && curr.stop <= k) {
                    dist[e.dest] = curr.cost + e.wt;
                    q.offer(new Pair(e.dest, dist[e.dest], curr.stop + 1));
                }
            }
        }

        if(dist[dest] != Integer.MAX_VALUE) {
            return dist[dest];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}; 
        int src = 0, dest = 3, k = 1;
        System.out.println(cheapestFlight(flights, src, dest, k));
    }
}
