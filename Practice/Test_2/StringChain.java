package Practice.Test_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringChain {
    private List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        StringChain stringChain = new StringChain();
        stringChain.setInput();
        stringChain.chain();
    }

    private void chain() {
        String result = chain(strings, "", "");
        System.out.println(result);
    }

    private String chain(List<String> temp, String longestString, String current) {
        for (String string : temp) {
            List<String> chain = new ArrayList<>(temp);
            chain.remove(string);
            if (canConcatenate(current, string)) {
                String concatenated = new StringBuilder(current).append(string).toString();
                if (longestString.length() < concatenated.length())
                    longestString = concatenated;
                longestString = chain(chain, longestString, concatenated);
            }
        }
        return longestString;
    }

    private boolean canConcatenate(String current, String str) {
        if (current.length() == 0)
            return true;
        Character last = current.toLowerCase().charAt(current.length() - 1);
        Character first = str.toLowerCase().charAt(0);
        return last == first;
    }

    private void setInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = scanner.nextInt();

        System.out.println("Elements");
        for (int i = 0; i < n; i++) {
            strings.add(scanner.next());
        }
        scanner.close();
    }

}
