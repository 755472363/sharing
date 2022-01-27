package com.hyk.sharing.objectInit2;

/**
 * 分享案例，话题引入：
 * 问题：执行结果是什么？
 */
class Person {
    String name = "人名";

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
    String name = "张三";
    Person person1 = new Person();
    static Person person2 = new Person();

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











