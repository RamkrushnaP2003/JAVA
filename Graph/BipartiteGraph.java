import java.util.*;

public class BipartiteGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest){
            this.dest = dest;
            this.src = src;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 -> vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 1 -> vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // 2 -> vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // 3 -> vertex
        graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));

        // 4 -> vertex
        graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
    }

    // time complexity -> O(V+E)
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;//yellow -> 0 || 1 -> blue
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if(color[e.dest] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isBipartite2(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++) {
            if(color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(i);
                        if(color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if(color[curr] == color[e.dest]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v=5;
        /* if graph doest have cycle -> bipartite
                0--------2
               /         |
              1          |
               \         |
                3--------4
         */
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(isBipartite2(graph));
    }
}
