import java.util.*;

public class HeapDS {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();
        
        public void add(int data) { // O(log n)
            arr.add(data);
            int x = arr.size() - 1; // x is child index
            int parent = (x - 1)/2; // parent index
            // arr.get(child) >  arr.get(parent) for max heap
            while (arr.get(x) < arr.get(parent)) { // O(log n)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
                x = parent;
                parent = (x-1)/2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) { // time complexity -> O(log n)
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            // arr.get(minIdx) < arr.get(left) for max heap
            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            // arr.get(minIdx) < arr.get(right) for max heap
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            
            if(minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // step 1 -> swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step 2 -> delete last
            arr.remove(arr.size()-1);

            // step 3 -> heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}