public class stringFunction {
    public static String subStrin(String str, int s, int e) {
        String subString = "";
        for(int i=s; i<e; i++) {
            subString += str.charAt(i);
        }
        return subString;
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(str.substring(0, 5));
        System.out.println(subStrin(str, 0, 5));
    }
}
