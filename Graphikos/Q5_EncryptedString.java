package Graphikos;

public class Q5_EncryptedString {
    public static void main(String[] args) {
        Q5_EncryptedString encryptedString = new Q5_EncryptedString();

        encryptedString.find("a3", 1);
    }

    private void find(String string, int k) {
        int[] array = new int[string.length() / 2 + 1];
        int index = 0, j = 0;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) > 65) {
                str.append(string.charAt(i));
                int times = string.substring(j, i) == ""
                 ? 0
                 : Integer.parseInt(string.substring(j, i));
                
                array[index] = array[index > 0 ? index - 1 : 0] + times;
                index++;
                j = i + 1;
            }
        }

        array[index] = array[index - 1] 
                        + Integer.parseInt(string.substring(j, string.length()));

        for (int i = 0; i < array.length; i++) {
            if(array[i] > k) {
                index = i;
                break;
            }
        }
        System.out.println(str.charAt(index - 1));
    }
}
