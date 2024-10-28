import java.util.*;

public class UnionIntersection {
    public static void union(int nums1[], int nums2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums1) {
            set.add(i);
        }
        for(int i : nums2) {
            set.add(i);
        }
        System.out.println(set);
        System.out.println("Union : "+set.size());
        set.clear();
        for(int i : nums1) {
            set.add(i);
        }
        int count = 0;
        for(int i : nums2) {
            if(set.contains(i)) {
                count++;
                System.out.print(i+" ");
                set.remove(i);
            }
        }
        System.out.println();
        System.out.println("Intersetion : "+count);
    }

    public static void main(String[] args) {
        int nums1[] = {7, 3, 9};
        int nums2[] = {6, 3, 9, 2, 9, 4};
        union(nums1, nums2);
    }
}
