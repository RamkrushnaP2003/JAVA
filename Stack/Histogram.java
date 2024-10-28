import java.util.*;

public class Histogram {
    // time complexity -> O(n)
    public static int maxArea(int height[]) {
        int n = height.length;
        int max = 0;     
        int nsl[] = new int[n];
        int nsr[] = new int[n];
        Stack<Integer> s = new Stack<>();

        // next smallest left to right
        for(int i=0; i<n; i++) {
            while(!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        s = new Stack<>();
        // next smallest right to left
        for(int i=n-1; i>=0; i--) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        for(int i=0; i<n; i++) {
            int h = height[i];
            int w = nsr[i]-nsl[i]-1;
            int area = h * (w * 1);
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        int height[] = {2, 1, 5, 5, 6, 2, 3};
        System.out.println("Maximum area in histogram : " + maxArea(height));
    }
}
