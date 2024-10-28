public class printOnetoN {
    public static void printIncrease(int n) {
        if(n == 1) {
            System.out.print(n+" ");
            return;
        }
        printIncrease(n-1);
        System.out.print(n+" ");
    }

    public static void printIncrease2(int n) {
        if(n==0) return;
        printIncrease2(n-1);
        System.out.println(n);
    }

    static int count = 0;
    public static void print() {
        if(count == 5) return;
        System.out.println(++count);
        print();
    }

    public static void main(String[] args) {
        int n = 10;
        // printIncrease(n);
        // print();
        printIncrease2(n);
    }
}
