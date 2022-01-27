package com.hyk.sharing.objectInit2.demo1;

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
        System.out.println("Teacher 构造函数，running。。。");
    }
}

/**
 * 单个类：构造函数、一般属性
 * <p>
 * 问题：一般属性怎么执行，如何赋值？
 * 答：先默认初始，显示初始化
 * <p>
 * <p>
 * 1，加载.class文件进内存
 * 2，在栈内存stu1开辟空间
 * 3，在堆内存为Student1对象开辟空间
 * 4，对Student1对象的成员变量进行默认初始化
 * 5，对Student1对象的成员变量进行显示初始化
 * 6，通过构造方法对Student1对象的成员变量赋值
 * 7，Student1对象初始化完毕，把对象地址赋值给stu1变量
 */
class Student1 {
    String name = "张三";
    String address = "58总部";

    public Student1() {
        System.out.println("Student 构造函数，running。。。");
        System.out.println("name:" + name);
        System.out.println("address:" + address);
    }

    // 方法，初始化不执行
    private void method() {
        System.out.println("method run。。。");
    }
}


/**
 * 单个类：构造函数、一般属性/+代码块
 * <p>
 * 问题：是一般属性先赋值，还是代码块先执行？是否和顺序有关？
 * 答：和代码顺序有关
 */
class Student2 {
    String name = "张三";
    // 学生有一个班主任老师
    Teacher teacher = new Teacher();

    {
        // 调整顺序，再次执行； //todo
        System.out.println("代码块，runing。。。");
    }

    public Student2() {
        System.out.println("student 构造函数，runing。。。");
    }
}


/**
 * 单个类：构造函数、一般属性/代码块，静态属性/静态代码块
 * <p>
 * 问题：加上 静态属性和静态代码块后，初始化顺序？
 * 答：静态属性/代码块先初始化，一般属性/代码块后初始化
 */
class Student3 {
    String name = "张三";
    // 先于一般属性加载
    static String address = "101号楼";

    // 学生有一个班主任老师
//    Teacher teacher = new Teacher();

    // 静态属性
    static Teacher teacher = new Teacher();

    {
        System.out.println("代码块，runing。。。");
    }

    static {
        // 调整顺序，再次执行； //todo
        System.out.println("静态代码块，runing。。。");
    }

    public Student3() {
        System.out.println("student 构造函数，runing。。。");
    }

    // 静态方法，初始化不执行
    private static void method() {
        System.out.println("static method run。。。");
    }

}


class Demo {
    public static void main(String[] args) throws Exception {
//        Student1 stu1 = new Student1();
//        Student2 stu2 = new Student2();
//        Student3 stu3 = new Student3();
//        // 静态代码初始化，只执行一次
//        Student3 stu3_2 = new Student3();

        /**
         * 扩展：类加载机制；
         * Java类加载机制，你理解了吗？
         * https://baijiahao.baidu.com/s?id=1636309817155065432&wfr=spider&for=pc
         *
         * 类加载的方式：forName和loaderClass区别
         * Class.forName()得到的class是已经初始化完成的。
         * Classloader.loaderClass得到的class是还没有链接（验证，准备，解析三个过程被称为链接）的。
         */
//        ClassLoader classLoader = Demo.class.getClassLoader();
        //通过Class.forName()方法动态加载，会默认执行初始化块（static{}）
//        Class stu3Class3 = Class.forName("com.hyk.sharing.objectInit.demo1.Student3");
        // Class.forName(name,initialize,loader)中的initialze可指定是否要执行初始化块
//        Class.forName("com.hyk.sharing.objectInit.demo1.Student3", false, classLoader);
//        // newInstance，执行初始化;
//        stu3Class3.newInstance();
//        //通过ClassLoader.loadClass()方法动态加载，不会执行初始化块
//        classLoader.loadClass("com.hyk.sharing.objectInit.demo1.Student3");
        new Thread(() -> {
            System.out.println("abadgsdg");
        }).start();

        new Thread(() -> {
            new Demo().test1();
        });
        Thread.sleep(10000);
        System.out.println("======1=======");
    }

    private void test1() {
        System.out.println("======2=========");
    }
}










