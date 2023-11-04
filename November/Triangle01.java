package November;

public class Triangle01 {
    public static void main(String[] args) {
        Triangle01 triangle01 = new Triangle01();
        triangle01.form(5);
    }

    private void form(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((i + j) % 2 + " ");
            }
            System.out.println();
        }
    }
}
