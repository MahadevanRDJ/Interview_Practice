package August;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IsoMorphicString {

    public static void main(String[] args) {
        IsoMorphicString isoMorphicString = new IsoMorphicString();
        System.out.println((int) 'a');
        System.out.println(isoMorphicString.isIsomorphic("title", "paper"));
    }
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character cs = s.charAt(i);
            Character ts = t.charAt(i);
            if (map.containsKey(cs)) 
                if (map.get(cs) != ts)
                    return false;
            map.put(cs, ts);
        }
        
        return map.keySet().size() == new HashSet<>(map.values()).size();
    }


}
