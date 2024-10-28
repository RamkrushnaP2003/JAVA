import java.util.*;

public class CycleDetection {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest){
            this.dest = dest;
            this.src = src;
        }
    }

    // public static void createGraph(ArrayList<Edge>[] graph) {
    //     for(int i=0; i<graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     // 0 -> vertex
    //     graph[0].add(new Edge(0, 1));
    //     // graph[0].add(new Edge(0, 2));
    //     graph[0].add(new Edge(0, 3));

    //     // 1 -> vertex
    //     graph[1].add(new Edge(1, 0));
    //     graph[1].add(new Edge(1, 2));

    //     // 2 -> vertex
    //     // graph[2].add(new Edge(2, 0));
    //     graph[2].add(new Edge(2, 1));

    //     // 3 -> vertex
    //     graph[3].add(new Edge(3, 0));
    //     graph[3].add(new Edge(3, 4));

    //     // 4 -> vertex
    //     graph[4].add(new Edge(4, 3));
    // }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
    }

    // for Bi-directional graph
    // time complexity -> O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }    
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }      
            } else if(vis[e.dest] && e.dest != parent) {
                return true;
            }
        }
        return false;
    }

    // for unidirectoinal graph
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            } 
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v=5;
        /*
                0--------3
               /|        |
              1 |        |
               \|        |
                2        4
         */
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
