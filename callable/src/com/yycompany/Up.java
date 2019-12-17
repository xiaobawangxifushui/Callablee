package com.yycompany;


import java.util.concurrent.CountDownLatch;

public class Up {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            new  Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开了教室！");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("关门啦！");
    }
}
