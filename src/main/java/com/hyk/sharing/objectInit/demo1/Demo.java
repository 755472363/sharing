package com.hyk.sharing.objectInit.demo1;

/**
 * 讲解思路：
 * 可以先抛出一个复杂的问题：然后挨个讲解
 * 单个类：构造函数，一般属性/代码块（顺序问题），静态属性/静态代码块（顺序问题）
 * 继承类：构造函数，一般属性/代码块（顺序问题），静态属性/静态代码块（顺序问题）
 * 1.JVM找Student.class
 * 2.执行new：在堆中创建对象空间
 * 3.为成员属性：默认初始，显示初始化
 * 4.执行():执行构造方法
 */
class Teacher {
    public Teacher() {
        System.out.println("T");
    }
}

class Student {
    com.hyk.sharing.objectInit.demo1.Teacher t = new com.hyk.sharing.objectInit.demo1.Teacher();

    {
        System.out.println("S1");
    }

    public Student() {
        System.out.println("S2");
    }

    private void method() {
        System.out.println("method run");
    }
}

class Demo {
    public static void main(String[] args) {
        Student stu = new Student();
    }
}
