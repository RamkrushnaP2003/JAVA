import java.util.*;

public class IndianCoins {
    // time complexity ->O(n log n)
    public static void minChange(int amount) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int count = 0;
        Arrays.sort(coins, Comparator.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<coins.length; i++) {
            if(coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Total coins : "+count);
        for(int i=0; i<ans.size()-1; i++) {
            System.out.print(ans.get(i)+" + ");
        }
        System.out.print(ans.get(ans.size()-1));
        System.out.println();
    }

    public static void main(String[] args) {
        int amount = 590;
        minChange(amount);
    }
}
