public class Abstraction {
    public static void main(String[] args) {
        Mustang h = new Mustang();
        h.eat();
        h.walk();
    }
}

abstract class Animal {
    String color;

    Animal() {
        System.out.println("Animal constructor called");
    }

    void eat() {
        System.out.println("eats");
    }

    abstract void walk();
}

class Horse extends Animal {
    Horse() {
        System.out.println("horse constructor called");
    }

    void changeColor() {
        color = "dark brown";
    }

    void walk() {
        System.out.println("walk on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called");
    }
    void changeColor() {
        color = "white";
    }
    void walk() {
        System.out.println("walks on 2 legs");
    }
}
