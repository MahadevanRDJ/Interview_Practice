package September;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        SubstringWithoutRepeatingCharacters sWithoutRepeatingCharacters = new SubstringWithoutRepeatingCharacters();

        sWithoutRepeatingCharacters.find("abcdadcdbc");
        sWithoutRepeatingCharacters.findOptimized("abcdadcdbc");
    }

    private void find(String string) {
        int left = 0, right = 0, n = string.length(), length = 0, start = 0, end = 0;
        Set <Character> set = new HashSet<>();


        while (right < n) {
            if(!set.contains(string.charAt(right))) {
                if(length < right - left + 1){
                    length = right - left + 1;
                    start = left; end = right;
                }
                set.add(string.charAt(right++));
                
            } else {
                set.remove(string.charAt(left));
                left++;
            }
        }

        System.out.println(length);
        System.out.println(string.substring(start, end + 1));
    
    }

    private void findOptimized(String string) {
        int left = 0, right = 0, n = string.length(), length = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right < n) {
            if(map.containsKey(string.charAt(right))) {
                left = Math.max(map.get(string.charAt(right)) + 1, left); 
            }

            map.put(string.charAt(right), right);
            length = Math.max(length, right - left + 1);
            right++;
        }

        System.out.println(length);
    }
}
