public class multipleInherit {
    public static void main(String[] args) {
        Bear b = new Bear();
        // b.veg();
        // b.nonVeg();
        b.eat();
    }
}

interface Herbivore {
    void eat();
}

interface Carnivore {
    void eat();
}

class Bear implements Herbivore, Carnivore {
    public void eat() {
        System.out.println("Eat grass");
    }
    // public void eat() {
    //     System.out.println("Eat nonVeg also...");
    // }
}
