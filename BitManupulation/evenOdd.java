public class evenOdd {
    public static void evenOrOdd(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static void main(String[] args) {
        evenOrOdd(5);
        evenOrOdd(4);
    }
}
