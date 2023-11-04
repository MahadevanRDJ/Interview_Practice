package September;

import java.util.Iterator;
import java.util.TreeSet;

public class ThirdMaximum {
    public static void main(String[] args) {
        ThirdMaximum thirdMaximum = new ThirdMaximum();
        System.out.println(thirdMaximum.thirdMax(2, 2, 1, 3));

    }

    public int thirdMax(int... nums) {
        try {
            TreeSet<Integer> set = new TreeSet<Integer>(
                    (x, y) -> {
                        if (x < y)
                            return 1;
                        else if (y < x)
                            return -1;
                        else
                            return 0;
                    });

            for (int integer : nums) {
                set.add(integer);
            }
            System.out.println(set);
            if (set.size() < 3)
                return set.first();
            Iterator<Integer> it = set.iterator();
            int i = 0;
            while (i++ < 2)
                it.next();

            return it.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Completed");
        }
        return 0;
    }
}
