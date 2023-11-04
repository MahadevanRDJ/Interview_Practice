package November;

public class DiamondSpacePattern {
    public static void main(String[] args) {
        DiamondSpacePattern diamondSpacePattern = new DiamondSpacePattern();

        diamondSpacePattern.form(16);
    }

    private void form(int n) {

        int space = 0, star = n;
        for (int i = 0; i < n * 2 + 1; i++) {
            if(i == n) {
                star++;
                space -=2;
                continue;
            }
            star(star);
            spacing(space);
            star(star);
            space = (i < n) ? space + 2 : space - 2; 
            star = i < n ? star - 1 : star + 1;
            System.out.println();
        }
    }

    private void star(int star) {
        for (int j = 0; j < star; j++) {
            System.out.print("* ");
        }
    }

    private void spacing(int space) {
        for (int i = 0; i < space; i++) {
            System.out.print("  ");
        }
    }
}
