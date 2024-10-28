public class KeyPad {
    public static String[] keyPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void letterCombination(String str, int i, String combination) {
        if(str.length() == i) {
            System.out.println(combination);
            return;
        }
        int currChar = str.charAt(i);
        String map = keyPad[currChar - '0'];
        for(int j=0; j<map.length(); j++)  {
            letterCombination(str, i+1 , combination+map.charAt(j)+" ");
        }
    }

    public static void main(String[] args) {
        letterCombination("2345", 0, "");
    }
}