public class QueueArray{
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        // time complexity -> O(n)
        public void add(int data) {
            if(rear == size-1) {
                System.out.println("Queue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        // time complexity -> O(n)
        public int remove() {
            if(isEmpty()) {
                System.out.println("EMpty Queue");
                return -1;
            }
            int front = arr[0];
            for(int i=0; i<rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        // time complexity -> O(1)
        public int peek() {
            if(isEmpty()) {
                System.out.println("EMpty Queue");
                return -1;
            }
            return arr[0];
        }

        public void print() {
            if(isEmpty()) {
                System.out.println("EMpty Queue");
                return;
            }
            while (!isEmpty() ) {
                System.out.print(remove()+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(5);
        q.print();
        // System.out.println(q.remove());
        // System.out.println(q.peek());
    }
}