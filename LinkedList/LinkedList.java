public class LinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }        
    }

    public static Node head;
    public static Node tail;
    public static int size; // time complexity -> O(1)

    public void addFirst(int data) {
        Node newnode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // time complexity -> O(n)
    public int length() {
        Node temp = head;
        size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public int removeFirst() {
        if(head == null) {
            System.out.println("LL is empty");
            return -1;
        }
        size--;
        int val = head.data;
        head = head.next;
        return val;
    }

    public int removeLast() {// java has garbeg collector, it remove unlinked node 
        if(size == 0) {
            System.out.println("LL is empty");
            return -1;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i=0; i<length()-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        tail = prev;
        prev.next = null;
        size--;
        return val;
    }

    public int search(int key) { // O(n)
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // time complexity -> O(n)
    // space complexity -> O(n)
    public int helper(Node head, int key){
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1)  {
            return -1;
        }
        return idx + 1;
    }
    public int searchRcrzn(int key) {
        return helper(head, key);
    }

    // time complexity -> O(n)
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next =  prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        print();
    }

    // Find & Remove Nth node from End
    public void deleteNthNodeFromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if(n == sz) {
            head = head.next; // remove first
            return;
        }
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    // to check if LL is palidrom we use slow-fast pointer
    // where show pointer increase step by one (+1)
    // & fast pointer increase step by two (+2)    
    public boolean isPalindrom() {
        if(head == null || head.next == null) {
            return true;
        }
        Node midNode = findMid(head);// step1 -> Find mid
        Node prev = null; // step2 -> revrse 2 half LL
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;// right half head
        Node left = head;
        while (right != null) { // step3 -> Check if 1st half(left half) == 2nd half(right half)
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1 (Turtle)
            fast = fast.next.next; // +2 (Hare/rabbit)
        }
        return slow; // slow is now middle
    }
    
    // Detect cycle in Linked List
    // Floyd's cycle finding algorithm
    // we use turtle hare technique to fing cycle in LL
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }
        if(cycle == false) {
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        // find Middle Node
        Node mid = getMid(head);
        // left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        // merge
        return merge(newLeft, newRight);
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // middle Node
    }

    private Node merge(Node leftHead, Node rightHead) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (leftHead != null && rightHead != null) {
            if(leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }
        while(leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        while(rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public void zigZag() {
        //step 1 -> find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // step 2 -> reverse second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // step 3 -> alternate merge - zig-zag merger
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        while (left!=null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    // time complexity -> O(1)
    public void removeNode(Node node) {
        Node temp = head;
        for(;temp.next!=node;) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        // if cant access to head node then use this approach 
        // node.data = node.next.data;
        // node.next = node.next.next;
    }

    public Node reverseBetween(Node head, int left, int right) {
        Node temp = new Node(0);
        temp.next = head;
        Node prev = temp;
        for(int i=0; i<left-1; i++) {
            prev = prev.next;
        }
        Node curr = prev.next;
        for(int i=0; i<right-left; i++) {
            Node next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return temp.next;
    }

    // add of two LL
    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        Node temp1 = l1;
        Node temp2 = l2;
        while(temp1 != null || temp2 != null) {
            int sum = carry;
            if(temp1!=null) sum += temp1.data;
            if(temp2!=null) sum += temp2.data;
            Node newNode = new Node(sum%10);
            carry = sum / 10;
            curr.next = newNode;
            curr = curr.next;
            if(temp1!=null) temp1 = temp1.next;
            if(temp2!=null) temp2 = temp2.next;
        }
        if(carry != 0) {
            Node newNode = new Node(carry);
            curr.next = newNode;
        }
        return dummy.next;
    }

    public void swapNodePair() {
        if(head == null) return;
        Node node = head;
        while (node.next != null) {
            int val = node.data;
            node.data = node.next.data;
            node.next.data = val;
            if(node.next.next != null) {
                node = node.next.next;
            } else {
                node = node.next;
            }
        }
        print();
    }

    public void reverseNodeKGroup(Node head, int k) {
        Node temp = head;
        Node prevLast = null;
        while(temp != null) {
            Node KthNode = getKthNode(temp, k);
            if(KthNode == null) {
                if(prevLast != null) prevLast.next = temp;
                break;
            }
            Node nextNode = KthNode.next;
            KthNode.next = null;
            reverse(temp);
            if(temp == head) {
                head = KthNode;
            } else {
                prevLast.next = KthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
    }

    public Node getKthNode(Node temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public Node reverse(Node temp) {
        Node prev = null;
        Node curr = temp;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next =  prev;
            prev = curr;
            curr = next;
        }
        // temp = prev;
        return prev;
    }

    // time complexity -> O(n)
    // approach 1 
    public void delMidNode(Node head) {
        Node slow = head;
        Node fast = head.next;
        fast = fast.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        // another approach is swap val of mid and break the mid.next = mid.next.next
    }

    public void delMidNode2(Node head) {
        Node mid = head;
        Node curr = head;
        int idx = 0;
        while (curr != null) {
            curr = curr.next;
            idx++;
        }
        for(int i=1; i<idx/2; i++) {
            mid = mid.next;
        }
        mid.next = mid.next.next;
    }

    public int gcd(int val1, int val2) {
        while(val1 != val2) {
            if(val1 < val2) {
                val2 -= val1;
            } else {
                val1 -= val2;
            }
        }
        return val1;
    }

    public void insertGCD(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
            Node node  = new Node(gcd(curr.data, prev.data));
            node.next = prev.next;
            prev.next = node;
        }
    }

    public static void main(String ars[]) {
        LinkedList ll = new LinkedList();
        ll.addFirst(18);
        ll.addLast(6);
        ll.addLast(10);
        ll.addLast(3);
        ll.insertGCD(head);
        ll.print();
    }
}
        // for cycle LL
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head.next;
        // System.out.println(isCycle());
        // ll.removeCycle();
        // System.out.println(isCycle());