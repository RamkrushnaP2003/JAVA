public class repeatedMissing {
    public static void repeatedMissingEle(int arr[]) {
        int count[] = new int[arr.length+1];
        for(int i=0; i<arr.length; i++) {
            count[arr[i]]++;
        }
        int repeated = 0;
        for(int i=1; i<count.length; i++) {
            if(count[i] > 1) {
                repeated = count[i];
                count[i]--;
            } else {
                System.out.println(count[i]);
            }
        }
        System.out.println(repeated);
    }

    public static void main(String[] args) {
        int arr[] = {3, 1 , 2, 5, 3};
        repeatedMissingEle(arr);
    }
}
