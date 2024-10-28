import java.util.*;

public class BellmanFord {
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

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }

    public static void createGraph2(ArrayList<Edge> graph2) {
        graph2.add(new Edge(0, 1, 2));
        graph2.add(new Edge(0, 2, 4));
        graph2.add(new Edge(1, 2, -4));
        graph2.add(new Edge(2, 3, 2));
        graph2.add(new Edge(3, 4, 4));
        graph2.add(new Edge(4, 1, -1));
    }

    // time complexity -> O(VE)
    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int V=graph.length;
        int dist[] = new int[V];
        for(int i=0; i<V; i++) {
            if(i!=src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<V-1; i++) {
            // edge
            for(int j=0; j<V; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for(int i=0; i<V; i++) {
            System.out.print(dist[i] + " ");
        } 
        System.out.println();
    }

    public static void bellmanFord(ArrayList<Edge> graph2, int src, int V) {
        int dist[] = new int[V];
        for(int i=0; i<V; i++) {
            if(i!=src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<V-1; i++) {
            // edge
            for(int j=0; j<graph2.size(); j++) {
                Edge e = graph2.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(int i=0; i<V; i++) {
            System.out.print(dist[i] + " ");
        } 
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        ArrayList<Edge> graph2 = new ArrayList<>();
        createGraph(graph);
        createGraph2(graph2);
        bellmanFord(graph, 0);
        bellmanFord(graph2, 0, v);
    }
}
