public class constructors {
    public static void main(String[] args) {
        // constructor overloading       -------------
        // Student s1 = new Student();               |--> non paramiterized constructor
        // Student s2 = new Student("Ramkrushna");   |--> parameterized constructor
        // Student s3 = new Student(123);  -----------
        Student s1 = new Student(); // ---------------
        s1.name = "Ramkrushna"; //                   |
        s1.roll = 123; //                            |
        s1.password = "abcd"; //                     |
        s1.marks[0] = 100; //                        |
        s1.marks[1] = 90; //                         |
        s1.marks[2] = 80; //                         |--> copy constructor
        //                                           |
        Student s2 = new Student(s1); //             |
        s2.password = "xyz"; //                      |
        s1.marks[1] = 100; //                        |
        for(int i=0; i<3; i++) { //                  |
            System.out.println(s2.marks[i]); //      |
        } // -----------------------------------------
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    // not parameterized constructor
    Student() {
        marks = new int[3];
        System.out.println("Constructor is called...");
    }

    // parameterized constructor
    Student(String name) {
        this.name = name;
        System.out.println(name);
    }
    Student(int roll) {
        this.roll = roll;
        System.out.println(roll);
    }

    // shallow copy constructor
    // Student(Student s1) { --------
    //     marks = new int[3];      |
    //     this.name = s1.name;     |
    //     this.roll = s1.roll;     |-->Shallow
    //     this.marks = s1.marks;   |
    // }    -------------------------

    // deep copy constructor
    Student(Student s1) { // --------------------
        marks = new int[3]; //                  |                  
        this.name = s1.name; //                 |
        this.roll = s1.roll; //                 |
        for(int i=0; i<marks.length; i++) {//   |-->Deep
            this.marks[i] = s1.marks[i]; //     |
        } //                                    |
    }//------------------------------------------
}