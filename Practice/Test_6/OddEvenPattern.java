package Practice.Test_6;

public class OddEvenPattern {
    public static void main(String[] args) {
        OddEvenPattern oddEvenPattern = new OddEvenPattern();
        oddEvenPattern.form(5);
    }

    private void form(int n) {
        int odd = 1, even = 2;
        for (int i = 1; i <= n; i++) {
            spacing(n - i);
            if (isEven(i))
                even = printUpto(i, even);
            else
                odd = printUpto(i, odd);
            System.out.println();
        }
    }

    private boolean isEven(int i) {
        return (i % 2) == 0;
    }

    private int printUpto(int n, int num) {
        for (int j = 0; j < n; j++) {
            System.out.print(num + " ");
            num += 2;
        }
        return num;
    }

    private void spacing(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("  ");
        }
    }
}
