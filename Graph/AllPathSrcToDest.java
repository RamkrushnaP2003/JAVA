import java.util.*;

public class AllPathSrcToDest {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest){
            this.dest = dest;
            this.src = src;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int v) {
        for(int i=0; i<v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // time complexity -> O(V^V) in worst case
    public static void dfs(ArrayList<Edge>[] graph, int src, int dest, StringBuilder sb) {
        if(src == dest) {
            System.out.println(sb.append(src));
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            dfs(graph, e.dest, dest, sb.append(e.src));
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        int v=6;
        /*
                5---->0<-----4
                |     |      |
                |     |      |
                \/    |      \/
                2---->3----->1  
         */
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph, v);
        dfs(graph, 5, 1, new StringBuilder());
    }
}
