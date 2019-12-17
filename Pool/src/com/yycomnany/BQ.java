package com.yycomnany;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BQ {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<>(3);
       /* System.out.println(integers.add(1));
        System.out.println(integers.add(2));
        System.out.println(integers.add(3));*/
//        System.out.println(integers.add(1));
//        System.out.println(integers.element());
       /* System.out.println(integers.remove());
        System.out.println(integers.remove());
        System.out.println(integers.remove());*/
//        System.out.println(integers.remove());
       /* System.out.println(integers.offer(1));
        System.out.println(integers.offer(2));
        System.out.println(integers.offer(3));*/
//        System.out.println(integers.offer(1));
        /*System.out.println(integers.peek());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());*/
//        integers.put(1);
//        integers.put(2);
//        integers.put(3);
//        System.out.println("2222");
//        integers.put(4);
//        integers.take();
//        System.out.println("3333");
        System.out.println(integers.offer(1, 1L, TimeUnit.SECONDS));
        System.out.println(integers.offer(2, 2L, TimeUnit.SECONDS));
        System.out.println(integers.offer(3, 3L, TimeUnit.SECONDS));

    }
}
