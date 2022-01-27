package com.hyk.sharing.objectInit.demo2;

/**
 *
 */
class Person {
    public Person() {
        System.out.println("P");
    }
}

class Student extends Person {
    public Student() {
        System.out.println("S");
    }
}

class Demo {
    public static void main(String[] args) {
        Student stu1 = new Student();
        Student stu2 = new Student();
    }
}





