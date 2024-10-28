import java.util.PriorityQueue;

public class SortByFreq {
    static class Pair {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static String sortByFreq(String str) {
        int[] freq = new int[128];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }
        for(int i=0; i<128; i++) {
            if(freq[i] != 0) {
                pq.add(new Pair((char)i, freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair top = pq.remove();
            for(int i=0; i<top.freq; i++) {
                sb.append(top.ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "raaeaedere";
        System.out.println(sortByFreq(str));
    }
}
