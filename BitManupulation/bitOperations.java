public class bitOperations {
    public static int getIhtBit(int n, int i) {
        int bitMask = 1<<i;
        if((n & bitMask) != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1<<i);
        return n&bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0) {
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        // n = clearIthBit(n, i);
        // int bitMask = newBit<<i;
        // return n|bitMask;

        // Step - 1 : clear ith bit 
        int bitMask1 = ~(1<<i);
        n = n & bitMask1;
        // step 2 : set the ith bit = newBit
        int BitMask = newBit<<i;
        return n | BitMask;
    }

    public static int cleariBits(int n, int i) {
        int bitMask = (~0)<<i;
        return n & bitMask;
    }

    public static int clearItoJBits(int n, int i, int j) {
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static void main(String[] args) {
        // System.out.println(getIhtBit(15, 2));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(14, 2, 0));
        // System.out.println(cleariBits(15, 2));
        System.out.println(clearItoJBits(10, 2, 4));
    }
}
