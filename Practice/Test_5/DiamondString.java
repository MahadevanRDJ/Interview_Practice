package Practice.Test_5;

public class DiamondString {
    public static void main(String[] args) {
        DiamondString diamondString = new DiamondString();
        diamondString.form("Mahadevan");
    }

    private void form(String string) {
        int n = string.length(),  m = n / 2;
        int left = m - 1, right = m + 1;

        for (int i = 0; i < n; i++) {
            if(i == 0 || i == n - 1) {
                for (int j = 0; j < m; j++) System.out.print("  ");
                System.out.println(string.charAt(i));
            }
            
            System.out.println(string.charAt(left) );
        }
    }
}
