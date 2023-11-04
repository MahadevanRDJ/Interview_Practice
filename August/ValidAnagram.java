package August;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        ;
    }

    public boolean isAnagram(String s, String t) {
        if (s == "" || t == "" || s.length() != t.length())
            return false;
        // return sorted(s).equals(sorted(t));

        // for (int i = 0; i < s.length(); i++) {
        // char charS = s.charAt(i);
        // int sIndex = -1, tIndex = -1;
        // while (sIndex < s.length()) {
        // if ((s.indexOf(charS, sIndex)) != -1 &&
        // ((t.indexOf(charS, tIndex)) != -1))
        // {
        // sIndex = s.indexOf(charS, sIndex);
        // tIndex = t.indexOf(charS, tIndex);
        // tIndex++; sIndex++;
        // continue;
        // }
        // return false;
        // }

        // }
        Map<Character, Integer> sMap = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            sMap.put(charS, sMap.get(charS) == null ? 1 : sMap.get(charS) + 1);
        }
        
        for (int j = 0; j < t.length(); j++) {
            char charT = t.charAt(j);
            if(sMap.get(charT) == null) return false;
            sMap.put(charT, sMap.get(charT) - 1);
            if(sMap.get(charT) >= 0) counter++;
        }

        return counter == s.length();
    }
}
