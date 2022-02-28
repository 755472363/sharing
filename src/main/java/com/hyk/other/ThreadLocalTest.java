package com.hyk.other;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    int a = 0;
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    private void plus() {
        Executor executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    a = threadLocal.get();
                    ++a;
                    threadLocal.set(a);
                    System.out.println("plus:" + Thread.currentThread().getName() + ": " + a);
                }
            });
        }
    }

    public static void main(String[] args) {
        new ThreadLocalTest().plus();
    }
}
