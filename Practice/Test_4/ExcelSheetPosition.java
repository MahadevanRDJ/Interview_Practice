package Practice.Test_4;

public class ExcelSheetPosition {
    public static void main(String[] args) {
        ExcelSheetPosition excelSheetPosition = new ExcelSheetPosition();
        excelSheetPosition.calculate("AAAAA");
    }

    private void calculate(String string) {
        int sum = 0, n = string.length();
        for (int i = 0 ; i < n; i++) 
            sum += ((string.charAt(i) - 64) * Math.pow(26, n - i - 1));
        
        System.out.println(sum);
    }
}
