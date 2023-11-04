package Generics;

class Group <T> {
    T[] data = (T[]) new Object[10];
    int size = 0;

    public void add(T data) {
        this.data[size++] = data;
    }

    public T get(int index) {
        return data[index];
    } 
}
