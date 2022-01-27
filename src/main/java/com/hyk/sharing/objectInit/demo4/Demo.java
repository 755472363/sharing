package com.hyk.sharing.objectInit.demo4;

/**
 *
 */
class Person {
    String name = "person";

    {
        System.out.println("P1");
    }

    static {
        System.out.println("P2");
    }

    public Person() {
        System.out.println("P3");
    }
}

class Student extends Person {
    String name = "student";

    {
        System.out.println("S1 " + name);
    }

    static {
        System.out.println("S2");
    }

    public Student() {
        System.out.println("S3 " + name);
    }
}

class Demo {
    public static void main(String[] args) {
        Student stu1 = new Student();
    }
}






