public class DoublyLL {
    public static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public int removeFirst() {
        if(head == null) {
            return -1;
        }
        if(head.next == null) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        head.prev = null;
        return val;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public int removeLast() {
        if(head == null) {
            System.out.println("Doubly LL is Empty");
            return -1;
        }
        if(head.next == null) {
            head = tail = null;
            size = 0;
            return -1;
        }
        int val = tail.data;
        size--;
        tail = tail.prev;
        tail.next = null;
        return val;
    }

    public void print() {
        Node temp = head;
        System.out.print("null<->");
        while (temp != null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void length() {
        if(head == null) {
            System.out.println("DLL is empty");
            return;
        }
        Node temp = head;
        int sz=0;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        System.out.println("LL length : "+sz);
    }

    public int search(int key) {
        if(head == null) {
            return -1;
        }
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(key == temp.data) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return i;
    }

    public void add(int n, int data) {
        if (n == 1) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 1;
        while (i < n-1) {
            i++;
            temp = temp.next;
        }
        newNode.next = temp.next;
        if(newNode.next != null) temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.add(2, 7);
        dll.print();
        dll.reverse();
        dll.print();
    }
}
