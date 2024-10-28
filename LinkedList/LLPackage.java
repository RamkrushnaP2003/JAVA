import java.util.LinkedList;

public class LLPackage {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(0);
        ll.addLast(1);
        ll.addLast(2);
        System.out.println(ll);
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
        for(int i=0; i<6; i++) {
            System.out.print(i + " ");
        }
    }
}
