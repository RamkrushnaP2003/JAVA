import java.util.*;

public class MST {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.dest = dest;
            this.src = src;
            this.wt = wt;
        }

        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int v, cost;
    
        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair P2) {
            return this.cost - P2.cost;
        }
    }

    // public static void createGraph(ArrayList<Edge>[] graph){
    //     for(int i=0; i<graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0, 1, 10));
    //     graph[0].add(new Edge(0, 2, 15));
    //     graph[0].add(new Edge(0, 3, 30));

    //     graph[1].add(new Edge(1, 0, 10));
    //     graph[1].add(new Edge(1, 3, 40));

    //     graph[2].add(new Edge(2, 0, 15));
    //     graph[2].add(new Edge(2, 3, 50));

    //     graph[3].add(new Edge(3, 1, 40));
    //     graph[3].add(new Edge(3, 2, 50));
    // }

    public static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("Minimum cost of MST : "+finalCost);
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static int find(int x) {
        if(x == par[x]) return x;
        // path compression
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if(par[parA] == par[parB]) {
            par[parB] = parA;
            par[parA]++;
        } else if(par[parA] > par[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    public static void init() {
        for(int i=0; i<n; i++) {
            par[i] = i;
        }
    }
    
    // time compleity -> O(V+ElogE)
    public static void kruskals(ArrayList<Edge> graph, int V) {
        init();
        Collections.sort(graph);
        int minCost = 0;
        int count = 0;
        for(int i=0; count<V-1; i++) {
            Edge e = graph.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            if(parA != parB) {
                union(e.src, e.dest);
                minCost += e.wt;
                count++;
            }
        }
        System.out.println("MST : "+minCost);
    }

    public static void main(String[] args) {
        /*
                    --0--
                 10/  |  \
                  /   |   \30
                 1  15|    3
                  \   |   /
                 40\  |  /50
                    --2--
         */

        // @SuppressWarnings("unchecked")
        // ArrayList<Edge>[] graph = new ArrayList[4];
        // createGraph(graph);
        // prims(graph);
        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        kruskals(graph, V);
    }
}
