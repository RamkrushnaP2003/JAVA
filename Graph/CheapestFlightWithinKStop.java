import java.util.*;

public class CheapestFlightWithinKStop {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.dest = dest;
            this.src = src;
            this.wt = wt;
        }
    }

    public static void createGraph(int[][] flights, ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<graph.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info{
        int v, cost, stops;

        public Info(int v, int cost, int s) {
            this.cost = cost;
            this.v = v;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        Queue<Info> q = new LinkedList<>();
        int dist[] = new int[flights.length];
        for(int i=0; i<n; i++) {
            if(i!=src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        q.add(new Info(src, 0, 0));
        
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                break;
            }
            for(int i=0; i<graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                // int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(e.dest, dist[v], curr.stops + 1));
                }
            }
        }
        if(dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    public static void main(String[] args) {
        int flights[][] = {{1,0,5}};
        int src = 0;
        int dest = 4;
        int n=2;
        int k = 1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
}
