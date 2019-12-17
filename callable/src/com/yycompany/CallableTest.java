package com.yycompany;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCall implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("44444");
        return 3333;
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCall myCall = new MyCall();
        FutureTask task = new FutureTask(myCall);
        new Thread(task,"2").start();
        System.out.println(task.get());
    }
}
