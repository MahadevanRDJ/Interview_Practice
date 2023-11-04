package September;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterFrequencySort {

    Map<Character, Integer> map = new HashMap<>();
    List<List<Character>> buckets = new ArrayList<>(); 
    public static void main(String[] args) {
        CharacterFrequencySort characterFrequencySort = new CharacterFrequencySort();
        String str = "MAhadevan";
    
        characterFrequencySort.sort(str);
    }

    private void sort(String str) {
        char [] a = str.toCharArray();

        for (char c : a) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }

        for (int i = 0; i < a.length; i++) buckets.add(new ArrayList<>());
        for (char c : map.keySet()) {
            int frequnecy = map.get(c);
            
            if(buckets.get(frequnecy) == null) 
                buckets.set(frequnecy, new ArrayList<>());
            
            buckets.get(frequnecy).add(c);
        }
        System.out.println(buckets);
        
        StringBuilder string = new StringBuilder();
        for(List<Character> list : buckets) {
            int frequnecy = buckets.indexOf(list);
            if(list.size() > 0) {
               for (int i = 0; i < list.size(); i++) 
                    for (int j = 0; j < frequnecy; j++) 
                        string.append(list.get(i));
                    
               
            }
        }
        System.out.println(string.reverse().toString());
    }
}
