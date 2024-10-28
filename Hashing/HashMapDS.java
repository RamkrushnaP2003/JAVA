import java.util.*;

public class HashMapDS {
    static class HashMap<K, V> { // generic
        private class Node {
            K key;
            V value;
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            } 
        }
        private int n; // n
        private int N;
        private LinkedList<Node> buckets[];  // N
        @SuppressWarnings("unchecked") //
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hs = key.hashCode();
            return Math.abs(hs) % this.N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash() {
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[this.N*2];
            this.N = 2*this.N;
            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            for(int i=0; i<oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); // found ? valid : -1;
            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                this.n++;
            }
            double lambda = (double)n/N;
            if(lambda > 2.0) {// 2.0 = threshold value
                reHash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di == -1 ? false : true;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di != -1) {
                Node node = buckets[bi].remove(di);
                this.n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1 ? buckets[bi].get(di).value : null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<this.N; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return this.n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 100);
        map.put("China", 150);
        map.put("US", 50);
        map.put("Nepal", 5);
        ArrayList<String> keys = map.keySet();
        System.out.println(keys);
        System.out.println(map.get("India"));
        System.out.println(map.get("US"));
        System.out.println(map.get("UAE"));
    }
}
