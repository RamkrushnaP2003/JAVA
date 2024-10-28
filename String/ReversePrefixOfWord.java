public class ReversePrefixOfWord {
    public static void reversePrefix(String str, char ch) {
        int bp = str.indexOf(ch);
        if(bp==-1) return;
        char chs[] = str.toCharArray();
        int i=0;
        while (i<=bp) {
            char temp = chs[i];
            chs[i] = chs[bp];
            chs[bp] = temp;
            i++;bp--;
        }
        System.out.println(new String(chs));
    }

    public static void main(String[] args) {
        String str = "abcdefd";
        char ch = 'd';
        reversePrefix(str, ch);
    }
}