package Recursion;

public class MultipleRecursion {
    public static void main(String[] args) {
        MultipleRecursion multipleRecursion = new MultipleRecursion();
        multipleRecursion.example1();
    }

    private void example1() {
        recursion(3,3);
    }

    private void recursion(int i, int j) {
        if(i > 0) {
            recursion(i - 1, j + 1);
            System.out.println(i + " " + j);
            recursion(i - 1, j + 1);
        }
    }
    
}
