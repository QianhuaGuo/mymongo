package com.qianhua.mongo.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static int count;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0;i<100;i++){
            new Thread(()->ReentrantLockDemo.inc()).start();
        }
    }

    public static void inc(){
        lock.lock();
        try{
            count++;
            System.out.println("count:"+count);
        } finally {
            lock.unlock();
        }
    }
}
