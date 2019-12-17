package com.yycompany;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            final int temp = i;
            new  Thread(()->{
                boolean flag = false;
                try {
                    semaphore.acquire();
                    System.out.println("车牌为："+temp+"的车辆停入车库！");
                    flag=true;
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("车牌为："+temp+"的车辆开出车库！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if (flag==true){

                        semaphore.release();
                    }
                }

            }).start();
        }

    }
}
