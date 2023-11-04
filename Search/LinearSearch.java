package Search;

class LinearSearch implements Search {

    @Override
    public int search(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target)
                return i;
        }
        return -1;
    }

}
