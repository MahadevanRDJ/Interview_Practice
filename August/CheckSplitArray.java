package August;

import java.util.List;

public class CheckSplitArray {
    public static void main(String[] args) {
        CheckSplitArray checkSplitArray = new CheckSplitArray();

        String s = "Mdaf";
        char[] str = s.toCharArray();

        ;
        System.out.println(new StringBuilder().append(str, 0, str.length).toString());
        List<Integer> list = List.of(2, 3, 3, 2, 3);
        checkSplitArray.find(list, 6);
    }

    private boolean find(List<Integer> list, int target) {
        if(list.size() < 3) return true;

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) + list.get(i - 1) == target) return true;
        }

        return false;
    }
   
}
