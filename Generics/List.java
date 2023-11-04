package Generics;

class List {
    private Object[] items = new Object[10];
    private int size;

    public void add(Object data) {
        items[size++] = data;
    }

    public Object get(int index) {
        return items[index];
    }
}
