package com.yycompany;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BQ {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(3);
//        System.out.println(arrayBlockingQueue.add(1));
//        System.out.println(arrayBlockingQueue.add(2));
//        System.out.println(arrayBlockingQueue.add(3));
//        System.out.println(arrayBlockingQueue.add(4));
        arrayBlockingQueue.offer(1, 2L, TimeUnit.SECONDS);
        arrayBlockingQueue.offer(2, 4L, TimeUnit.SECONDS);
        arrayBlockingQueue.offer(3, 6L, TimeUnit.SECONDS);
        System.out.println("ddddddd");
        arrayBlockingQueue.offer(4, 1L, TimeUnit.SECONDS);
        System.out.println("ccccccc");
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        System.out.println("aaaaaaaa");
        arrayBlockingQueue.poll(5L,TimeUnit.SECONDS);
        arrayBlockingQueue.offer(1);
        System.out.println(arrayBlockingQueue.size());

    }
}
