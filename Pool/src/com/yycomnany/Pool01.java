package com.yycomnany;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool01 {
    public static void main(String[] args) {
//        ExecutorService executorService =  Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 10; i++) {
                final int temp = i;
                executorService.execute(()-> System.out.println(Thread.currentThread().getName()+"受理了"+temp));
            }
        }finally {
               executorService.shutdown();
        }
    }
}
