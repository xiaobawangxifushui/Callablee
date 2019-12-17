package com.yycomnany;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int ticket = 30;
    private int count = 1;
    private Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if (ticket>=1){
                ticket--;
                System.out.println(Thread.currentThread().getName()+"销售了第"+(count++)+"张票");
            }
        }finally {
            lock.unlock();
        }
    }
}

public class Pool02 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            for (int i = 1; i <= 30; i++) {
                executorService.execute(ticket::sale);
            }
        }catch (Exception e){

        }finally {
            executorService.shutdown();
        }
    }
}
