package com.qianhua.mongo.demo;

public class ThreadDemo {

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.run();
        System.out.println(Thread.interrupted());
    }

    static class T1 implements Runnable{
        @Override
        public void run() {
            System.out.println("t1 thread....");
            System.out.println("isInterrupted:"+Thread.currentThread().isInterrupted());//false
            Thread.currentThread().interrupt();//设置中断 true

        }
    }
}
