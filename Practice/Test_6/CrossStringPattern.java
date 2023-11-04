package Practice.Test_6;

public class CrossStringPattern {
    public static void main(String[] args) {
        CrossStringPattern crossStringPattern = new CrossStringPattern();

        crossStringPattern.form("zohofinances");
    }

    private void form(String string) {
        char[] arr = string.toCharArray();

        int n = arr.length - 1;
        int x = 0, y = n - 1, m = n / 2;


        for (int i = 0; i < arr.length; i++) {
            spacing(x);
            System.out.print((i < m) ? arr[i] : arr[n - i] + " "); 
            spacing(y);
            if(x != m) System.out.print((i > m) ? arr[i] : arr[n - i] +  " ");
            spacing(x);
            System.out.println();

            if(i < m) { 
                x++;
                y -= 2;
            } else {
                x--;
                y += 2;
            }
        }
    }

    private void spacing(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }
}
