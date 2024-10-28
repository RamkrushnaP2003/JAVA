import java.util.*;

public class ReverseStack {
    // time complexity -> O(n)
    // space complexity -> O(n)
    // public static void reverseStack(Stack<Integer> s, Stack<Integer> temp) {
    //     while (!s.empty()) {
    //         int top = s.peek();
    //         temp.push(top);
    //         s.pop();
    //     }
    //     while (!temp.isEmpty()) {
    //         System.out.println(temp.peek());
    //         temp.pop();
    //     }
    // }

    public static void reverseStack2(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack2(s);
        pushAtBottom(s, top);
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void print(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // 3, 2, 1
        reverseStack2(s);
        // 1, 2, 3
        print(s);
    }
}
