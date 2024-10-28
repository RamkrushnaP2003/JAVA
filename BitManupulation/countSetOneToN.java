public class countSetOneToN {
    public static int countSetBitOneToN (int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            while(i>0) {
                if((i&1)!=0) {
                    count++;
                }
                i=i>>1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBitOneToN(4));
    }
}
