package com.hyk.lock;

public class SynchronizedDemo {
    static final Object obj = new Object();

    public static void method1() throws InterruptedException {
        synchronized (obj) {
            // 同步块 A
            System.out.println("method1 = " + obj);
            method2();
        }
    }

    public static void method2() throws InterruptedException {
        synchronized (obj) {
            // 同步块 B
            Thread.sleep(1000);
            System.out.println("method2 = " + obj);
        }
    }

    public static void method3() {
        while (true) {
            System.out.println("============");
            synchronized (obj) {
                // 同步块 C
                System.out.println("method3 = " + obj);
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        method1();
        new Thread(SynchronizedDemo::method3, "1111").start();
    }

}
