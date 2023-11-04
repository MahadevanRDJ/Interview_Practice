package July;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.find("abba", "cat dog dog cat"));
        System.out.println(wordPattern.findOptimized("a", "a"));;
    }

    private boolean findOptimized(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<String, Integer> index = new HashMap<>();
    
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i) + "", i) != index.put(words[i], i))
                return false;
        return true;
    }

    private boolean find(String pattern, String string) {
        Set<String> setPattern = new HashSet<>();
        Set<String> setString = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++)
            setPattern.add(pattern.charAt(i) + "");
        String[] splited = string.split(" ");
        for (String str : splited) 
            setString.add(str);
        
        return setPattern.size() == setString.size();
    }
}