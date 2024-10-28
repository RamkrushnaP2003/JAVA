import java.util.*;

public class HashSetDS {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(39);
        set.add(21);
        set.add(33);
        set.add(434);
        set.add(5);
        System.out.println(set);
        // Iterator i = set.iterator();
        // while (i.hasNext()) {
        //     System.out.println(i.next());
        // }
        // for(int i : set) {
        //     System.out.println(i);
        // }
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        set2.add(39);
        set2.add(21);
        set2.add(33);
        set2.add(434);
        set2.add(5);
        System.out.println(set2);

        // Not allowed null value
        TreeSet<Integer> set3 = new TreeSet<>();
        set3.add(39);
        set3.add(21);
        set3.add(33);
        set3.add(434);
        set3.add(5);
        System.out.println(set3);
    }    
}