package November;

public class DiamondStar {
    public static void main(String[] args) {
        DiamondStar diamondStar = new DiamondStar();
        diamondStar.form(28);
    }

    private void form(int n) {
        int space = n, star = 1;
        for (int i = 0; i < n * 2 + 1; i++) {
            if (i == n) {
                space += 2;
                star -= 4;
                continue;
            }

            spacing(space);
            star(star);
            space = i < n ? space - 1 : space + 1;
            star = i < n ? star + 2 : star - 2;
            System.out.println();
        }
    }

    private void star(int star) {
        for (int i = 0; i < star; i++) {
            System.out.print("* ");
        }
    }

    private void spacing(int space) {
        for (int i = 0; i < space; i++) {
            System.out.print("  ");
        }
    }
}
