package August;

import java.util.HashSet;
import java.util.Set;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("ababba"));
    }
    
    public boolean repeatedSubstringPattern(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        while(set.add(s.charAt(count++)));
        count--; 
        
        while(2 * count <= s.length() 
            && s.substring(0, count).equals(s.substring(count, 2 * count)))
            return true;
        
        return false;
    }
}
