public class FriendPair {
    public static int FriendPairing(int n) {
        // if(n == 1 || n == 2) {
        //     return n;
        // }
        // // choise
        // //single
        // int single = FriendPairing(n-1);
        // // pair
        // int paired = FriendPairing(n-2);
        // int totalWays = single + (n-1) * paired;
        // return totalWays;

        return n==1 || n==2 ? n : FriendPairing(n-1) + (n-1) * FriendPairing(n-2);
    }

    public static void main(String[] args) {
        int n=4;
        System.out.println(FriendPairing(n));
    }
}
