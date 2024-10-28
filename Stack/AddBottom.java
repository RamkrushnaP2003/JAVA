import java.util.*;

public class AddBottom {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void print(Stack<Integer> s){
        if(s.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s, 4);
        print(s);
    }
}
