public class MinMoveToConvertStr {
    // You are given a string s consisting of n characters which are either 'X' or 'O'.

    // A move is defined as selecting three consecutive characters of s and converting them to 'O'. Note that if a move is applied to the character 'O', it will stay the same.

    // Return the minimum number of moves required so that all the characters of s are converted to 'O'.
    
    public static int minimumMoves(String str) {
        int i=0, step = 0;
        while(i<str.length()) {
            if(str.charAt(i) == 'X') {
                i+=3;
                step++;
            } else {
                i++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        String str = "XOXO";
        System.out.println(minimumMoves(str));
    }
}
