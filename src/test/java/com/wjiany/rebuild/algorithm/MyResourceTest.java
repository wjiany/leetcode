package com.wjiany.rebuild.algorithm;

import com.wjiany.rebuild.juc.productsconsumer.MyResource;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

public class MyResourceTest {

    @Test
    public void testMyResource(){
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        for (int i = 0 ; i< 10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        myResource.myProd();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i = 0 ; i< 10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        myResource.myConsumer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        while(true){

        }
    }
}