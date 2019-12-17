package com.yycompany;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Share{
    private  int status = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print()  {
        if ("A".equals(Thread.currentThread().getName())){
            lock.lock();
            try {
                while (status!=1){
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <6; i++) {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
                status=2;
                c2.signal();
            }finally {
                lock.unlock();
            }

        }
        if ("B".equals(Thread.currentThread().getName())){
            lock.lock();
            try {
                while (status!=2){
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <11; i++) {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
                status=3;
                c3.signal();
            }finally {
                lock.unlock();
            }

        }
        if ("C".equals(Thread.currentThread().getName())){
            lock.lock();
            try {
                while (status!=3){
                    try {
                        c3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <16; i++) {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
                status=1;
                c1.signal();
            }finally {
                lock.unlock();
            }

        }

    }
}


public class ABC {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 1; i < 10; i++)
                share.print();
        },"A").start();
        new Thread(()->{
            for (int i = 1; i < 10; i++)
                share.print();
        },"B").start();
        new Thread(()->{
            for (int i = 1; i < 10; i++)
                share.print();
        },"C").start();
    }
}
