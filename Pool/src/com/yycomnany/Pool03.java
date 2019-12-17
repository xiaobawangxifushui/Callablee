package com.yycomnany;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Pool03 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                6,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 11; i++) {
                final  int temp = i;
                threadPoolExecutor.execute(()->System.out.println(Thread.currentThread().getName()+"处理了"+temp));
            }
        }finally {
                 threadPoolExecutor.shutdown();
        }

    }
}
