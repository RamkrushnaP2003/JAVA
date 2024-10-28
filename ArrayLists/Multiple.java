import java.util.*;

public class Multiple {
    public static ArrayList<ArrayList<Integer>> StoreELe(ArrayList<ArrayList<Integer>> ans) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i=1; i<=5; i++) {
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        ans.add(list1);
        ans.add(list2);
        ans.add(list3);
        return ans;
    }

    public static void main(String args[]) {
        // ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        // ArrayList<Integer> mainlist = new ArrayList<>();
        // mainlist.add(1);
        // mainlist.add(2);
        // ls.add(mainlist);
        // ArrayList<Integer> mainlist2 = new ArrayList<>();
        // mainlist2.add(3);
        // mainlist2.add(4);
        // ls.add(mainlist2);
        // // System.out.println(ls);
        // for(int i=0; i<ls.size(); i++) {
        //     ArrayList<Integer> currList = ls.get(i);
        //     for(int j=0; j<currList.size(); j++) {
        //         // System.out.println(currList.get(j));
        //     }
        // }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // System.out.println(StoreELe(ans));
        ArrayList<ArrayList<Integer>> ls1 = StoreELe(ans);
        for(int i=0; i<ls1.size(); i++) {
            ArrayList<Integer> ls3 = ls1.get(i);
            for(int j=0; j<ls3.size(); j++) {
                System.out.print(ls3.get(j)+" ");
            }
            System.out.println();
        }
        
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println(ans);
    }
}
