package com.yycomnany;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ABC{
    private  int status = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try {
            while(status!=1){
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println("A    "+i);
            }
            status=2;
            c2.signal();
        }catch (Exception e){

        }finally {
           lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            while(status!=2){
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println("B    "+i);
            }
            status=3;
            c3.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            while(status!=3){
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println("C    "+i);
            }
            status=1;
            System.out.println("----------------------------------------------------------");
            c1.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}

public class Pool04 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(3, 10, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        ABC abc = new ABC();
        try {
            for (int i = 1; i <= 10; i++) {
                executorService.execute(abc::print5);
                executorService.execute(abc::print10);
                executorService.execute(abc::print15);
            }

        }finally {
            executorService.shutdown();
        }
    }
}
