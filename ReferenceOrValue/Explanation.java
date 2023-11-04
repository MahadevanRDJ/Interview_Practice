package ReferenceOrValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Explanation {
    public static void main(String[] args) {
        Integer integer = 10;
        String name = "Krishna";
        int [][]A ={{1, 2, 3, 4, 5}};
        Integer [] B = new Integer[] {1, 2, 3, 4, 4};
        Explanation explanation = new Explanation();
        explanation.find(A.clone());
        // explanation.find(B.clone());
        explanation.find(integer);
        explanation.find(name);
        Demo demo = null;
        demo.print();
        // demo.display();
        System.out.println("After modification: " + Arrays.deepToString(A)); // prints
        System.out.println(Arrays.toString(B));
        System.out.println(integer);
        System.out.println(name);
        List <Integer> list =  Arrays.asList(B);
        System.out.println(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : list) {
            System.out.println(map.put(num, 1));
        }
        System.out.println(new HashSet<>(list).size() == B.length);
    }

    private void find(String name) {
        name = "Deva";
    }

    private void find(Integer integer) {
        integer = 12;
    }

    private void find(int[] a) {
        a = Arrays.copyOf(a, 0);
    }

    private void find(int[][] a) {
        a[0][3] = -1;
    }
}

class Demo {
    public static void print() {
        System.out.println("bkjsgb");
    }
    
    public void display() {
        System.out.println("Display");
    }
}