import java.util.*;

public class ConnectingCityWithMinCost {
    // static class Edge {
    //     // int src;
    //     int dest;
    //     int cost;

    //     public Edge(int dest, int cost){
    //         this.dest = dest;
    //         // this.src = src;
    //         this.cost = cost;
    //     }
    // }

    static class Edge {
        int src;
        int dest;
        int cost;

        public Edge(int src, int dest, int cost){
            this.dest = dest;
            this.src = src;
            this.cost = cost;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] cities) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<cities.length; i++) {
            for(int j=0; j<cities[0].length; j++) {
                if(cities[i][j] != 0) {
                    graph[i].add(new Edge(i, j, cities[i][j]));
                }
            }
        }
    }

    static class Pair {
        int v, cost;
    
        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    // time complexity -> O(V+Elogn)
    // public static int connectCities(int[][] cities) {
    //     PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
    //     boolean[] vis = new boolean[cities.length];
    //     pq.add(new Edge(0, 0, 0));
    //     int minCost = 0;
    //     while (!pq.isEmpty()) {
    //         Edge curr = pq.poll();
    //         if(!vis[curr.dest]) {
    //             vis[curr.dest] = true;
    //             minCost += curr.cost;
    //             for(int i=0; i<cities[curr.dest].length; i++) {
    //                 if(cities[curr.dest][i] != 0) {
    //                     pq.add(new Edge(i, cities[curr.dest][i]));
    //                 }
    //             }
    //         }
    //     }
    //     return minCost;
    // }

    public static int connectCities(int[][] cities, ArrayList<Edge>[] graph) {
        int minCost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] vis = new boolean[cities.length];
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                minCost += curr.cost;
                for(int i=0; i<graph[curr.v].size(); i++) {
                    pq.add(new Pair(graph[curr.v].get(i).dest, graph[curr.v].get(i).cost));
                }
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        int cities[][] = {{0, 1, 2, 3, 4},
                          {1, 0, 5, 0, 7},
                          {2, 5, 0, 6, 0},
                          {3, 0, 6, 0, 0},
                          {4, 7, 0, 0, 0}};
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[cities.length];
        createGraph(graph, cities);
        System.out.println(connectCities(cities, graph));
    }
}
