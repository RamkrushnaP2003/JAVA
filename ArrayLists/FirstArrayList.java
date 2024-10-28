import java.util.*;

public class FirstArrayList {

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();

        // Add element
        // time complexity -> O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2, 15);
        System.out.println(list+" -> "+list.size());

        // get element
        // time complexity -> O(1)
        int ele = list.get(2);
        System.out.println(ele);

        // Remove Element
        // time complexity -> O(n)
        list.remove(2);
        System.out.println(list);

        // Set element at index
        // time complexity -> O(n)
        list.set(2, 10);
        System.out.println(list);

        // contains elements
        // time complexity -> O(n)
        System.out.println(list.contains(10));
        System.out.println(list.contains(6));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}