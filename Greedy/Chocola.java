import java.util.*;

public class Chocola {
    // time complexity -> O(n log n)
    public static void main(String[] args) {
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};
        int n=4, m=6;

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int v=0, h=0; // pointer
        int hp=1, vp=1; // peices count
        int cost = 0;

        while(h < costHor.length && v < costVer.length) {
            if(costVer[v] <= costHor[h]) {
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while(h < costHor.length) {
            cost += (costHor[h] * vp);
            h++;
            hp++;
        }

        while(v < costVer.length) {
            cost += (costVer[v] * hp);
            v++;
            vp++;
        }

        System.out.println("Min cost to cut : "+cost);
    }
}
