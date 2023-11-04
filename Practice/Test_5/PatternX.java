package Practice.Test_5;

public class PatternX {
    public static void main(String[] args) {
        PatternX patternX = new PatternX();

        patternX.form(13, 1);
    }

    private void form(int n, int times) {
        int x = 0, y = n - 2, m = n / 2;

        for (int i = 0; i < n; i++) {
            
            spacing(x);
            System.out.print("* ");
            spacing(y);
            if(i != m) System.out.print("* ");
            spacing(x);
            System.out.println();
            if (i < m) {
                x++;
                y -= 2;
            } else {
                x--;
                y += 2;
            }
        }
    }

    private void spacing(int n) {
         for (int j = 0; j < n; j++)
                System.out.print("  ");

    }
}
