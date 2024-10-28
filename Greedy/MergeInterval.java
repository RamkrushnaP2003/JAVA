import java.util.*;

public class MergeInterval {
    // time complexity -> O(n log n + 2n)
    // space complexity -> O(n)
    public static void merge(int intervals[][]) {
        int n = intervals.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingDouble(o->o[1]));
        for(int i=0; i<n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!list.isEmpty() && end <= list.get(list.size()-1).get(1)) {
                continue;
            }
            for(int j=i+1; j<n; j++) {
                if(intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            list.add(Arrays.asList(start, end));
        }
        System.out.println(list);
    }

    // time complexity -> O(n log n + 2n)
    // space complexity -> O(n)
    public static void merge2(int intervals[][]) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int end = intervals[i][1];
            int start = intervals[i][0];
            if(!list.isEmpty() && end <= list.get(list.size()-1)[1]) {
                continue;
            } 
            for(int j=i+1; j<n; j++) {
                if(end >= intervals[j][0]) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            list.add(new int[] {start, end});
        }
        int ans[][] = list.toArray(new int[list.size()-1][2]);
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<2; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void merge3(int intervals[][]) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        for(int i=0; i<n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(list.isEmpty() || start > list.get(list.size()-1)[1]) {
                list.add(intervals[i]);
            } else {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], end);
            }
        }
        System.out.print("[ ");
        for(int ans[] : list) {
            System.out.print("[ ");
            for(int i : ans) {
                System.out.print(i+" ");
            }
            System.out.print("], ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        int intervals[][] = {{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}};
        // merge(intervals);
        // merge2(intervals);
        merge3(intervals);
    }
}
