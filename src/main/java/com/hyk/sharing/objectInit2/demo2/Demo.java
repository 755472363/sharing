package com.hyk.sharing.objectInit2.demo2;

/**
 * 继承关系：构造函数，一般属性/代码块，静态属性/静态代码块
 * 问题：继承关系，初始化执行顺序是什么？
 */
class Person {
    String name = "person";

    {
        System.out.println("Person 代码块，runing。。。");
    }

    static {
        System.out.println("Person 静态代码块，runing。。。");
    }

    public Person() {
        System.out.println("Person 构造函数，runing。。。");
    }
}

class Student extends Person {
    String name = "student";

    {
        System.out.println("Student 代码块，runing。。。");
    }

    static {
        System.out.println("Student 静态代码块，runing。。。");
    }

    public Student() {
        System.out.println("Student 构造函数，runing。。。");
    }
}

class Demo {
    public static void main(String[] args) {
        Student stu1 = new Student();
    }
}

