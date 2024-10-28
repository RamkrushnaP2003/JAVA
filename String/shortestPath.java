// Given a route containing 4 directions (E, W, N, S),
// find the shortest path to reach destination
// "WNEENESENNN";

public class shortestPath {
    // time complexity -> O(n)
    public static float getShortestPath(String path) {
       int x = 0, y = 0;
       for(int i=0; i<path.length(); i++) {
            if(path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'W') {
                x--;
            } else {
                x++;
            }
       }
       int x2 = x*x, Y2 = y*y;
       return (float)Math.sqrt(x2+Y2);
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getShortestPath(path));
    }
}
