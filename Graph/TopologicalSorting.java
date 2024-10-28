import java.util.*;

public class TopologicalSorting {
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
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topologicalSortingDFS(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topologicalSortingUtilDFS(graph, i, vis, s);
            }
        }

        while (!s.empty()) {
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }

    public static void topologicalSortingUtilDFS(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topologicalSortingUtilDFS(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void calIndeg(ArrayList<Edge>[] graph, int inDeg[]) {
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void topoSortBFS(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[graph.length];
        calIndeg(graph, inDeg);
        for(int i=0; i<graph.length; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if(inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v=6;
        /*
                5---->0<-----4
                |            |
                |            |
                \/           \/
                2----->3---->1  
         */
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        topologicalSortingDFS(graph);
        topoSortBFS(graph);
    }
}
