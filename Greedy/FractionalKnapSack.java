import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {
    public static void knapsack(int[] value, int weight[], int W) {
        double ratio[][] = new double[value.length][2];
        for(int i=0; i<value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }
        
        for(int i=0; i<value.length; i++) {
            System.out.println(ratio[i][0] + " " + ratio[i][1]);
        }
        System.out.println("-------------");
        // if p/w=ratio is not decsending
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1])); //Asc order sort
        for(int i=0; i<value.length; i++) {
            System.out.println(ratio[i][0] + " " + ratio[i][1]);
        }
        int capacity = W;
        int finalValue = 0;
        for(int i=ratio.length-1; i>=0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) { // include full item
                finalValue += value[idx];
                capacity -= weight[idx];
            } else {
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final value : "+finalValue);
    }

    public static void main(String[] args) {
        int value[] = {60, 120, 100};
        int weight[] = {10, 30, 20};
        int W = 50;
        knapsack(value, weight, W);
    }
}
