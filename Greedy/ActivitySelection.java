import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void activitySelection(int start[], int end[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int maxAct = 0;
        maxAct = 1; // ----------------
        ans.add(0); //             |->First activity done, max = 1;
        int lastEnd = end[0]; // ---
        for(int i=1; i<end.length; i++) {
            if(start[i]>=lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Maximum activity : "+maxAct);
        for(int i=0; i<ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }

    // time complexity -> O(n log n)
    // if end time is not sorted
    public static void activitySelection2(int start[], int end[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int activity[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }
        // lambda function 
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2])); //sorting col 2
        int maxAct = 0;
        maxAct = 1;
        ans.add(activity[0][0]);
        int lastEnd = activity[0][2];
        for(int i=1; i<end.length; i++) {
            if(activity[i][1] > lastEnd) {
                maxAct++;
                ans.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }
        System.out.println("Maximum activity : "+maxAct);
        for(int i=0; i<ans.size(); i++)
            System.out.print("A"+ans.get(i)+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int start [] = {2, 1};
        int end[] = {2 , 2};
        activitySelection2(start, end);
        // int activity[][] = new int[start.length][3];
        // for(int i=0; i<start.length; i++) {
        //     activity[i][0] = i;
        //     activity[i][1] = start[i];
        //     activity[i][2] = end[i];
        // }
        // for(int i=0; i<end.length; i++) {
        //     System.out.println(activity[i][0]+" "+activity[i][1]+" "+activity[i][2]);
        // }
        // System.out.println("------------------------");
        // Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));
        // for(int i=0; i<end.length; i++) {
        //     System.out.println(activity[i][0]+" "+activity[i][1]+" "+activity[i][2]);
        // }
    }
}