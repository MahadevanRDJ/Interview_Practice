package Collection;

import java.util.Hashtable;
import java.util.Map;

public class Hashing {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>(21);

        table.put(1234, "Deva");
        table.put(2343, "deva");
        table.put(1646, "sjfidf");
        
        for(Map.Entry<Integer,String> entry : table.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + " -> " + entry.getKey().hashCode());
        }

        String k = table.getOrDefault(134, "arun");

        System.out.println(table);
    }
}
