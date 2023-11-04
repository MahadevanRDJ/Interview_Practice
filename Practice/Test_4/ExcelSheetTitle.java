package Practice.Test_4;

public class ExcelSheetTitle {
    public static void main(String[] args) {
        ExcelSheetTitle excelSheetTitle = new ExcelSheetTitle();

        excelSheetTitle.form(703);

    }

    private void form(int columnNumber) {
        StringBuilder str = new StringBuilder();

        while (columnNumber > 0) {
            char c = (char) ((--columnNumber) % 26 + 'A');
            str.append(c);
            columnNumber /= 26;
        }

        System.out.println(str.reverse().toString());
    }

}
