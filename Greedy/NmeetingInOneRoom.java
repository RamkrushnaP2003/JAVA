import java.util.Arrays;
import java.util.Comparator;

public class NmeetingInOneRoom {
    public static int maxMeetings(int start[], int end[]) {
        int n = end.length;
        int maxMeeting = 0;
        int meetings[][] = new int[n][3];
        for(int i=0; i<n; i++) {
            meetings[i][0] = i;
            meetings[i][1] = start[i];
            meetings[i][2] = end[i];
        }
        Arrays.sort(meetings, Comparator.comparingDouble(o->o[2]));
        maxMeeting = 1;
        int lastEnd = meetings[0][0];
        // int lastEnd = end[0];
        for(int i=1; i<n; i++) {
            int idx = meetings[i][0];
            if(lastEnd <= meetings[idx][1]) {
                maxMeeting++;
                lastEnd = meetings[idx][2];
            }
        }
        return maxMeeting;
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] =  {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start, end));
    }
}
