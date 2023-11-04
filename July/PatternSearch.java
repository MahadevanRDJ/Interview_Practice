package July;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatternSearch {
    private String input;
    private String pattern;
    private List<List<Character>> result;

    public static void main(String[] args) {
        PatternSearch patternSearch = new PatternSearch();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Input string ");

        patternSearch.input = scanner.next();

        System.out.println("Pattern : ");
        patternSearch.pattern = scanner.next();

        patternSearch.search();
        scanner.close();
    }

    private void search() {
        permutations();
        for (List<Character> list : result) {
            String data = getString(list);
            if(input.contains(data)) {
                System.out.println(input.indexOf(data));
            }
        }
    }



   private String getString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(i -> sb.append(i));
        return sb.toString();
    }


    private void permutations() {
        List<Character> data = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            data.add(pattern.charAt(i));
        }
        permutations(data, new ArrayList<>());
    }

    private void permutations(List<Character> data, List<Character> permute) {
        if (data.size() == 0) {
            result.add(permute);
        }
        for (Character integer : data) {
            List<Character> tempdt = new ArrayList<>(data);
            List<Character> tempPermute = new ArrayList<>(permute);
            tempdt.remove(integer);
            tempPermute.add(integer);
            permutations(tempdt, tempPermute);
        }
    }
}
// Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
// search(char pat[], char txt[]) that prints all occurrences of pat[] and its
// permutations (or anagrams) in txt[]. You may assume that n > m.?
