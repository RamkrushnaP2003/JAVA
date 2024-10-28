import java.util.*;

public class InsertInterval {
    public static void insert(int intervals[][], int newInterval[]) {
        List<int[]> ans = new ArrayList<>();
        for(int[] i : intervals) {
            if(newInterval[0] > i[1]) {
                ans.add(i);
            } else if(newInterval[1] < i[0]) {
                ans.add(newInterval);
                newInterval = i;
            } else {
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }
        ans.add(newInterval);
        for(int[] i : ans.toArray(new int[ans.size()-1][])) {
            for(int ele : i) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int intervals[][] = {{1,2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int newInterval[] = {4, 8};
        insert(intervals, newInterval);
    }
}
