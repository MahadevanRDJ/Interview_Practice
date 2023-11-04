package PolyMorphism;

import java.util.HashSet;

public class MathUtils {

    
    
    Integer add(Integer a, Integer b) {
        System.out.println("Integer");
        return a + b;
    }

    // int add(int a, int b) {
    //     System.out.println("int");
    //     return a + b;
    // }

    // int add(int a, int b) {
    //     System.out.println("int 2");
    //     return a + b;
    // }

    long add(Long a, Long b) {
        System.out.println("long");
        return a + b;
    }

    double add(double a, double b) {
        System.out.println("double");
        return a + b;
    }

    int add (int a, long b) {
        return (int) (a + b);
    }

    int add (long a, int b) {
        return (int) (a + b);
    }

    
    // void print(int[] a) {
    //     System.out.println("array");
    //     for (int i = 0; i < a.length; ++i) {
    //         System.out.println(i);
    //     }
    // }

    // void print(int... a) {
    //     System.out.println("args");
    //     for (int i = 0; i < a.length; ++i) {
    //         System.out.println(i);
    //     }
    // }


    public static void main(String[] args) {
        // System.out.println(new MathUtils().add('a', 'b'));  
        int a[] = {1, 3, 4, 9 };
        // new MathUtils().print(a);
        String s = "BJP";
        String x = "DMK";
        


    }
}
