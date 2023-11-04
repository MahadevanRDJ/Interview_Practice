package November;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = { { 1, 3 }, { 8, 9 }, { 2, 4 }, { 2, 6 }, { 16, 17 }, { 9, 11 }, { 8, 10 }, { 15, 18 } };

        mergeIntervals.merge(intervals);
    }

    private void merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] < b[0])
                return -1;
            else if (a[0] > b[0])
                return 1;
            else
                return 0;
        });

        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {

            if (result.size() == 0 || result.get(result.size() - 1)[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                int end = intervals[i][1];
                int previousEnd = result.get(result.size() - 1)[1];
                result.get(result.size() - 1)[1] = Math.max(end, previousEnd);
            }

        }

        for (int[] mergedIntervals : result) {
            System.out.println(Arrays.toString(mergedIntervals));
        }

        // SpiralMatrix.print(intervals);
    }
}
