public class printNtoOne {
    public static void printDecreasing(int n) {
        if(n==1) {
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDecreasing(n-1);
    }

    // using backtracking
    // time & space complexity -> O(n)
    public static void printDecreasing2(int i, int n) {
        if(i>n) return;
        printDecreasing2(i+1, n);
        System.out.println(i);
    }

    static int count = 5;
    public static void print() {
        if(count == 0) return;
        System.out.println(count--);
        print();
    }

    public static void main(String[] args) {
        int n=10;
        // printDecreasing(n);
        // print();
        printDecreasing2(1, n);
    }
}