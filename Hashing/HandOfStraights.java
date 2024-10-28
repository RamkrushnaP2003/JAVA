import java.util.*;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : hand) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        Arrays.sort(hand);
        for(int i=0; i<hand.length; i++) {
            if(map.get(hand[i]) == 0) {
                continue;
            }
            for(int j=0; j<groupSize; j++) {
                int curr = hand[i] + j;
                if(map.get(curr) == 0) {
                    return false;
                }
                map.put(curr, map.get(curr)-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int hand[] = {8, 10, 12};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }
}
