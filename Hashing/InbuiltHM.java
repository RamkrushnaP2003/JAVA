import java.util.*;

public class InbuiltHM {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Create Opration -> O(1)
        map.put("India", 100);
        map.put("China", 150);
        map.put("US", 50);
        map.put("Indonesia", 5);
        map.put("Nepal", 6);
        System.out.println(map);

        // // using keySet() function
        // Set<String> key = map.keySet();
        // // System.out.println(key);
        // for (String k : key) {
        //     System.out.println("key="+k+" value="+map.get(k));
        // }

        for(Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}











































































































































































// Get opration -> O(1)
        // System.out.println(map.get("India"));

        // // ContainsKey -> O(1)
        // System.out.println(map.containsKey("India"));

        // // remove Opration -> O(1)
        // System.out.println(map.remove("China"));

        // System.out.println(map+" -> "+map.size());

        // map.clear();

        // System.out.println(map.isEmpty());