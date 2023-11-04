package July;


public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isValid("race a car"));
        System.out.println(validPalindrome.findOptimized("race a car"));
    }

   
    private boolean findOptimized(String string) {
        int i = 0;
        int j = string.length() - 1;
        while (i < j) {
            char a = string.charAt(i);
            char b = string.charAt(j);
            if (a >= 'A' && a <= 'Z') {
                a = (char) (a + 32);
            }
            if (b >= 'A' && b <= 'Z') {
                b = (char) (b + 32);
            }
            if (a < '0' || (a > '9' && (a < 'a' || a > 'z'))) {
                i++;
            } else if (b < '0' || (b > '9' && (b < 'a' || b > 'z'))) {
                j--;
            } else if (a != b) {
                return false;
            } else {
                i++;
                j--;
            }

        }
        return true;
    }


    private boolean isValid(String string) {
        string = string.replaceAll("[^A-Za-z0-9]", "");
        return isPalindrome(string.toLowerCase());
    }

    private boolean isPalindrome(String string) {
        int left = 0, right = string.length() - 1;
        while (left <= right)
            if (string.charAt(right--) != string.charAt(left++))
                return false;
        return true;
    }

}
