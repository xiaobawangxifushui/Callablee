package com.yycompany;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int ticket = 30;
    private Lock lock = new ReentrantLock();
    public void sale() {
        lock.lock();
        try {
            if (ticket >= 1) {
                System.out.println(Thread.currentThread().getName() + "销售了第" + (ticket--) + "张票");
            }
        } finally {
            lock.unlock();
        }
    }

}


public class Pool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Ticket ticket = new Ticket();
        try {
            for (int i = 1; i <= 30; i++) {
                executorService.execute(ticket::sale);
            }
        }finally {
            executorService.shutdown();
        }

    }
}

