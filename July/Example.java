package July;
import java.util.*;



class Example {
    public static void main(String[] args) {
        var x = new Subclass();
        
        Map <String, String> map = new HashMap<>();
        // Map <String, String> tree = new TreeMap<>();
        map.put("", "");
        map.put("Deva", "TVL");
        map.put("Hema", "CHE");
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

        for(Map.Entry<String, String> mp : map.entrySet()) {
            System.out.println(mp.getKey() + " " + mp.getValue());
        }

        List<Integer> list = new ArrayList<>(List.of(1, 2,3 , 2, 1));
        List<Integer> temp = new ArrayList<>(new HashSet<>(list));
        Set<Integer> set = new HashSet<>(list);
        System.out.println("List" + list);
        System.out.println("List" + temp);
        System.out.println("Set" + set);
    }
}

class Subclass implements Parent {
    @Override
    public void print() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        Parent.super.display();
        System.out.println(Base.x);
    }
}


/**
 * InnerExample
 */
interface Parent {
    int x = 9;
    void print();
    default void display() {
        System.out.println("Parent");
    }
    interface Nest {
        void show();
        default void live() {
            System.out.println("Live");
        }
    }
}

interface Base {
    int x = 5;
    void print();
    default void display() {
        System.out.println("Base");
    }
}
abstract class Super{
    public void display() {
        System.out.println("Super class");
    }
}