public class RemoveDuplicate {
    public static String removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()){
            // System.out.println(newStr);
            return newStr.toString();
        }
        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true) {
            //duplicate
            return removeDuplicate(str, idx+1, newStr, map);
        }else {
            map[currChar-'a'] = true;
            return removeDuplicate(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "Ramkrushna";
        String str1 = str.toLowerCase();
        System.out.println(removeDuplicate(str1, 0, new StringBuilder(""), new boolean[26]));
    }
}
