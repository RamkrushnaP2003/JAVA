import java.util.Arrays;
import java.util.Comparator;

public class MaxUnitOnTruck {
    public static int maximumUnits(int boxTypes[][], int truckSize) {
        int maxUnits = 0;
        Arrays.sort(boxTypes, Comparator.comparingDouble(o->o[1]));
        for(int i=boxTypes.length-1; i>=0; i--) {
            if(truckSize>= boxTypes[i][0]) {
                maxUnits += (boxTypes[i][0]*boxTypes[i][1]);
                truckSize -= boxTypes[i][0];
            } else {
                maxUnits += (boxTypes[i][1] * truckSize);
                truckSize = 0;
                break;
            }
        }
        return maxUnits;
    }

    public static void main(String[] args) {
        int boxTypes[][] = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }   
}
/*
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
 */