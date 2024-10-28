import java.util.ArrayList;

public class ArrayListStack {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty() {
            return list.size() == 0;
        }      

        // push element in stack
        public void push(int data) {
            list.add(data);
        }

        // pop element in stack
        public int pop() {
            if(isEmpty()) return -1;
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        // peek element in stack
        public int peek() {
            if(isEmpty()) return -1;
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);;
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}