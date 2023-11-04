package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Executor extends Base {
    
    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<? extends Collection<? extends Number>> list = new ArrayList<>();
        // list.add(intList);
        // System.out.println(list.get(0));
        System.out.println();
        new Executor().fun();

      
    }

    public void fun() {
        // System.out.println(.y);
    }
}


class Base {
    transient int y = 10;
    public void fun() {
        System.out.println("Base fun");
    }
}