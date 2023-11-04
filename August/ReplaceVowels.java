package August;

public class ReplaceVowels {

    public static void main(String[] args) {
        ReplaceVowels replaceVowels = new ReplaceVowels();
        System.out.println(replaceVowels.reverseVowels("leetcode"));;
        
    }

    public String reverseVowels(String str) {
        char[] s = str.toCharArray();
        int left = 0, right = s.length - 1;
        while (left < right) {
            char leftChar = s[left];
            char rightChar = s[right];
            boolean isLeft = isVowel(leftChar);
            boolean isRight = isVowel(rightChar);

            if (!isLeft) {
                left++;
                continue;
            }

            if (!isRight) {
                right--;
                continue;
            }

            if (isLeft && isRight) {
                s[left] = rightChar;
                s[right] = leftChar;
            }

            left++;
            right--;
        }

        return new String(s);

    }

    private boolean isVowel(int character) {
        character = character >= 'a' ? character: character - 32;
        System.out.println(character);
        return character == 'a' ||
                character == 'e' ||
                character == 'i' ||
                character == 'o' ||
                character == 'u';

    }
}
