package October;

import java.util.ArrayList;
import java.util.List;

public class Series47 {
    public static void main(String[] args) {
        Series47 series47 = new Series47();
        series47.find(10);
    }

    private void find(int n) {
        List<Integer> list = new ArrayList<>(List.of(0, 4, 7));

        for (int i = 3; i <= n; i++)
            if (i % 2 == 1)
                list.add(i, list.get(i / 2) * 10 + 4);
            else
                list.add(i, list.get(i / 2 - 1) * 10 + 7);

        System.out.println(list.get(n));
    }
}
