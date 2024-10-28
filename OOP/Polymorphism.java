public class Polymorphism {
    public static void main(String args[]) {
        // Calculator calc = new Calculator(); ----------
        // System.out.println(calc.sum(1, 2));          |--> compile-time polymorphism
        // System.out.println(calc.sum(1.4F, 2.6F));    |--> Method overloading
        // System.out.println(calc.sum(1, 2, 3)); -------
    
        // Dear d1 = new Dear();------------|-->Run-time polymorphism
        // d1.eat(); -----------------------|-->Method overriding
    }
}

// Compile - time polymorphism -> 1)Method Overloading
// class Calculator { -----------------------
//     int sum(int a, int b) {              |
//         return a+b;                      |
//     }                                    |
//     float sum(float a, float b) {        |
//         return a+b;                      |-->1) compile - time polymorphism
//     }                                    |--> Method Overloading
//     int sum(int a, int b, int c) {       |
//         return a+b+c;                    |
//     }                                    |
// }    ------------------------------------|

// Run - time polymorphism -> 1)Method Overriding
// class Animal {  --------------------------
//     void eat() {                         |
//         System.out.println("eats");      |
//     }                                    |
// }                                        |
//                                          |-->2) Run - time polymorphism
// class Dear extends Animal {              |--> Method overriding
//     void eat() {                         |
//         System.out.println("eats grass");|
//     }                                    |
// }  ---------------------------------------
