package com.hyk.sharing.objectInit.demo5;

/**
 *
 */
class Person {
    String name = "personName";
    static String address = "personAddress";

    {
        System.out.println("P1 " + name);
        System.out.println("P2 " + address);
    }

    static {
//        System.out.println("P1" + name);
        System.out.println("P3 " + address);
    }

    public Person() {
        System.out.println("P4 ");
    }
}

class Student extends Person {
    String name = "studentName";
    static String address = "studentAddress";
    static Person penson1 = new Person();
    Person penson2 = new Person();

    {
        System.out.println("S1 " + name);
        System.out.println("S2 " + address);
        System.out.println("S3 " + penson1);
        System.out.println("S4 " + penson2);
    }

    static {
        System.out.println("S5 ");
        System.out.println("S6 " + address);
        System.out.println("S7 " + penson1);
    }

    public Student() {
        System.out.println("S8 " + name);
    }
}

class Demo {
    public static void main(String[] args) {
        Student stu1 = new Student();
    }
}

/**
 * 执行顺序，最终总结：
 * 执行顺序：加载.class文件，静态属性，静态代码块，new对象，默认初始化/显示初始化，代码块初始化，构造函数初始化。
 * A类:1加载.class文件，2静态代码块，3new对象，4默认初始化，5显示初始化，6代码块初始化，7构造函数初始化。
 * B 类:1加载.class文件，2静态代码块，3new对象，4默认初始化，5显示初始化，6代码块初始化，7构造函数初始化。
 * B继承A，执行顺序：
 * B1A1-->A2-->B2-->B3B4-->A3A4A5A6A7--->B5B6B7
 */




