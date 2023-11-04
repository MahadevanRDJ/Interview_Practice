package September;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesString {
    public static void main(String[] args) {
        RemoveDuplicatesString removeDuplicatesString = new RemoveDuplicatesString();
        removeDuplicatesString.find("I I love zoho, and zoho is good");
    }

    private void find(String string) {
        String[] strs = string.split("[,. ]+");
        Set<String> set = new LinkedHashSet<>();
        for (String str : strs) {
            set.add(str);
        }

        System.out.println(set);
        Iterator<String> it = set.iterator(); 
        while(it.hasNext()) System.out.print(it.next()  + " ");
    }
}
