public class BinaryStr {
    // print all binary string of size N without consicutive 1;
    public static void printBinStrCon1(int n, int lastPlace, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }
        System.out.println(str);
        printBinStrCon1(n-1, 0, str+"0");
        // if(lastPlace==0) {
        //     printBinStrCon1(n-1, 1, str+"1");
        // }
        
        printBinStrCon1(n-1, 1, str+"1");
    }

    // print all binary string of size N without consicutive 0;
    public static void printBinStrCon0(int n, int lastPlace, String str) {
        if(n==0) {
            System.out.println(str);
            return;
        }
        printBinStrCon0(n-1, 0, str+"1");
        if(lastPlace == 0) {
            printBinStrCon0(n-1, 1, str+"0");
        }
    }

    public static void main(String[] args) {
        printBinStrCon1(3, 0, "");
    }
}
