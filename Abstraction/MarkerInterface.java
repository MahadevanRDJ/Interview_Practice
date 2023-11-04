package Abstraction;

public class MarkerInterface  {

    public static void main(String[] args) {
        PeriyaSumma summa = new Summa();
        Summa s = (Summa) summa;
        s.display();

        
    }
    
}
class Summa implements PeriyaSumma{
    void display() {
        System.out.println("Displaying summa");
    }
 }

interface PeriyaSumma{}