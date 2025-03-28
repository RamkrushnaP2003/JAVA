import java.util.*;

public class Dijkstra {
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

    static class Pair {
        int n;
        int path;
        
        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // vertext 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        // vertext 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        // vertex 2
        graph[2].add(new Edge(2, 4, 3));
        // vertext 3
        graph[3].add(new Edge(3, 5, 1));
        // vertex 4
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // time complexity -> O(V+Elogn)
    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.path - b.path);
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v=6;
        /*          (7)
                1--------3
            (2)/|        | \(1)
              0 |(1)  (2)|  5
            (4)\|        | /(5)
                2--------4
                    (3)
         */
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        dijkstra(graph, src);
    }
}
