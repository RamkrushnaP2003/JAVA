import java.util.*;

public class NonOverlapInterval {
    public static int eraseOverlapIntervals(int intervals[][]){
        Arrays.sort(intervals, Comparator.comparingDouble(o->o[1]));
        int count = 0;
        int lastEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < lastEnd) count++;
            else lastEnd = intervals[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        int intervals[][] = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
