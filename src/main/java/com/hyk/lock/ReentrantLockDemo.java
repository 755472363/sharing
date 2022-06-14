package com.hyk.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable {
    static ReentrantLock lock = new ReentrantLock();

    /**
     * @description ReentrantLock的lockInterruptibly()方法测试
     **/
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁");
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + "成功获取到了锁");
                Thread.sleep(100000);
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "业务方法执行期间异常");
            } finally {
                lock.unlock();
            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + "等待获取锁时候被中断异常");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo interceptLockTest = new ReentrantLockDemo();
        Thread t1 = new Thread(interceptLockTest);
        Thread t2 = new Thread(interceptLockTest);
        t1.start();
        t2.start();
        Thread.sleep(2000);
        t1.interrupt();
    }


//    public static void main(String[] args) {
//        method1();
//    }

    public static void method1() {
        lock.lock();
        try {
            System.out.println("execute method1");
            method2();
        } finally {
            lock.unlock();
        }
    }

    public static void method2() {
        lock.lock();
        try {
            System.out.println("execute method2");
            method3();
        } finally {
            lock.unlock();
        }
    }

    public static void method3() {
        lock.lock();
        try {
            System.out.println("execute method3");
        } finally {
            lock.unlock();
        }
    }


}
