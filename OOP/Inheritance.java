public class Inheritance {
    public static void main(String[] args) {
    }
}

class Animal {
    String color;

    void eat() {
        System.out.println("Eats");
    }

    void breath() {
        System.out.println("breaths");
    }
}

// class Fish extends Animal { ---------------
//     int fins;                             |
//                                           |
//     void swim() {                         |--> 1) Single level Inheritance
//         System.out.println("Swims");      |
//     }                                     |
// }   --------------------------------------|

// class Mammal extends Animal { -------------
//     int leg;                              |
// }                                         |
//                                           |--> 2) Multi-level Inheritance
// class Dog extends Mammal {                |
//     String bread;                         |
// } -----------------------------------------

// class Mammal extends Animal { -------------
//     void walk() {                         |
//         System.out.println("Walks");      |
//     }                                     |
// }                                         |
//                                           |
// class Fish extends Animal {               |
//     void swim() {                         |
//         System.out.println("swim");       |--> 3) Hierarchial Inheritance
//     }                                     |
// }                                         |
//                                           |
// class Bird extends Animal {               |
//     void fly() {                          |
//         System.out.println("Fly");        |
//     }                                     |
// } -----------------------------------------

// class Fish extends Animal { ---------------
//     void swim() {                         |
//         System.out.println("swim");       |
//     }                                     |
// }                                         |
//                                           |
// class Tuna extends Fish {                 |
//     void size() {                         |
//         System.out.println("small fish"); |
//     }                                     |
// }                                         |
//                                           |
// class Shark extends Fish {                |
//     void size() {                         |
//         System.out.println("Big fish");   |
//     }                                     |
// }                                         |
//                                           |
// class Bird extends Animal {               |
//     void fly() {                          |
//         System.out.println("fly");        |
//     }                                     |
// }                                         |
//                                           |
// class peacock extends Bird {              |
//     void look() {                         |
//         System.out.println("Beautiful");  |--> 4) Hierarchial Inheritance
//     }                                     |
// }                                         |
//                                           |
// class Mammal extends Animal {             |
//     void walk() {                         |
//         System.out.println("walk");       |
//     }                                     |
// }                                         |
//                                           |
// class Lion extends Mammal {               |
//     void type() {                         |
//         System.out.println("wild");       |
//     }                                     |
// }                                         |
//                                           |
// class Dog extends Mammal {                |
//     void bark() {                         |
//         System.out.println("barks");      |
//     }                                     |
// }                                         |
//                                           |
// class Human extends Mammal {              |
//     void talk() {                         |
//         System.out.println("talk");       |
//     }                                     |
// }------------------------------------------