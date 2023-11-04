package September;

public class SearchInMatrix {

    public static void main(String[] args) {
        SearchInMatrix searchInMatrix = new SearchInMatrix();
        int[][] A = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        System.out.println(searchInMatrix.searchMatrix(A, 60));;

        
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length - 1,  COLUMN = matrix[0].length - 1;
        int top = 0, bottom = ROW, row = 0;
        while (top <= bottom) {
            row = (bottom + top) / 2;
            if (target < matrix[row][0]) {
                bottom = row - 1;
            } else if (target > matrix[row][COLUMN]) {
                top = row + 1;
            } else
                break;
        }
        if(top < bottom) return false;

        return binarySearch(matrix[row], target);
    }

    private boolean binarySearch(int[] a, int target) {
        int left = 0, right = a.length - 1;

        
        
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target < a[mid]) {
                right = mid + 1;
            } else if (target > a[mid]) {
                left = mid + 1;
            } else
                return true;
        }

        return false;
    }
}
