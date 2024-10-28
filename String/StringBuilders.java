public class StringBuilders {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for(char ch='a'; ch<'z'+1; ch++) {
            sb.append(ch+" ");
        }
        System.out.println(sb);
    }
}
