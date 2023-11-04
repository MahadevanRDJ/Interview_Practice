package Search;

public class Executor {
    public static void main(String[] args) {
        Search search = new ExponentialSearch();
        int nums[] = { 1, 4, 6, 7, 8, 10, 45};
        System.out.println(search.search(nums, 10));
    }
}
