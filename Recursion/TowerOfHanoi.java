public class TowerOfHanoi {
    public static void towerOhHanoi(int n, String src, String helper, String dest) {
        if(n==1) {
            System.out.println("Transefered disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOhHanoi(n-1, src, dest, helper);
        System.out.println("Transefered disk "+n+" from "+src+" to "+dest);
        towerOhHanoi(n-1, helper, src, dest);
    }

    public static void main(String[] args) {
        towerOhHanoi(3, "a", "b", "c");
    }
}