package com.yycompany;

import java.util.ArrayList;
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

class Test implements  Runnable{
    private MyCall m;
    public  Test(MyCall m){
        this.m = m;
    }
    @Override
    public void run() {
        try {
            m.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCall myCall = new MyCall();
        FutureTask task = new FutureTask(myCall);
        new Thread(task,"2").start();
        System.out.println(task.get());
//        new Thread()

    }
}
