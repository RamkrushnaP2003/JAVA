// Constructor chaining
public class constChain {
    public static void main(String[] args) {
        new Human();
    }
}

class Animal {
    Animal() {
        this("Animal2");
        System.out.println("1) Animal constructor called...");
    }
    Animal(String name2) {
        this(5);
        System.out.println("2) Animal constructor caalled..."+name2);
    }
    Animal(int b) {
        this(10, 15);
        System.out.println("3) Animal constructor called..."+b);
    }
    Animal(int n, int x) {
        System.out.println("ok"+n+x);
    }
}

class Mammal {
    String name;
    Mammal() {
        this(5);
        System.out.println("1) Mammal");
    }
    Mammal(int no){
        this(5, 10);
        System.out.println("2) Mammal");
    }
    Mammal(int a, int b){
        System.out.println("3) Mammal");
    }
}

class Human extends Mammal {
    Human() {
        this(10);
        System.out.println("1) Human");
    }
    Human(int no) {
        this(10, 15);
        System.out.println("2) Human");
    }
    Human(int m, int n) {
        super(m+n);
        System.out.println(m+n);
    }
}