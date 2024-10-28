import java.util.*;

public class JobSequencing {
    static class Job {
        int deadline;
        int profit;
        int id; // 0, 1, 2

        public Job(int i, int d, int p) {
            this.deadline = d;
            this.id = i;
            this.profit = p;
        }
    }

    public static void maxPofit(int[][] jobInfo) {
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0; i<jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit); // Descending order profit
        int time = 0;
        ArrayList<Integer> seq = new ArrayList<>();
        for(int i=0; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(curr.deadline > time) {
                time++;
                seq.add(curr.id);
            }
        }
        System.out.println("Max jobs : "+seq.size());
        for(int i=0; i<seq.size(); i++) {
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {5, 30}};
        maxPofit(jobInfo);
    }
}
