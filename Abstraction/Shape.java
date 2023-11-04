package Abstraction;

abstract class Shape {
    protected int x, y;
    public Shape(int x, int y) {
    this.x = x;
        this.y = y;
    }
    abstract void draw();
}

class Circle extends Shape {

    public Circle(int x, int y) {
        super(x, y);        
    }

    @Override
    void draw() {
       System.out.println("Circle");
    }

    public static void main(String[] args) {
        // Shape shape = new Circle();

        // System.out.println(shape.x);
    }

}

