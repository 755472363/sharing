package com.hyk.sharing.objectInit.demo3;

/**
 *
 */
class Person {
    String name = "person";

    {
        System.out.println("P1");
    }

    public Person() {
        System.out.println("P2");
    }
}

class Student extends Person {
    String name = "student";

    {
        System.out.println("S1 " + name);
    }

    public Student() {
        System.out.println("S2 " + name);
    }
}

class Demo {
    public static void main(String[] args) {
        Student stu1 = new Student();
    }
}






