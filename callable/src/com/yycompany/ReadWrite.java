package com.yycompany;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteDemo {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void write() {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写入");
        } finally {
            System.out.println(Thread.currentThread().getName() + "写入完了");
            rwl.writeLock().unlock();
        }
    }

    public void read() {
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取");
        } finally {
            System.out.println(Thread.currentThread().getName() + "读取完了");
            rwl.readLock().unlock();
        }
    }

}

public class ReadWrite {
    public static void main(String[] args) {
        ReadWriteDemo readWriteDemo = new ReadWriteDemo();
        for (int i = 1; i <= 10; i++) {
            new Thread(readWriteDemo::write,String.valueOf(i)).start();
        }
        for (int i = 1; i <= 10; i++) {
            new Thread(readWriteDemo::read,String.valueOf(i)).start();
        }
    }
}
