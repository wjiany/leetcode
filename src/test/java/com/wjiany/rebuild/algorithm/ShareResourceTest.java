package com.wjiany.rebuild.algorithm;

import com.wjiany.rebuild.juc.productsconsumer.ShareResource;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

public class ShareResourceTest {

    @Test
    public void testMyResource(){
        ShareResource shareResource = new ShareResource(new ArrayBlockingQueue<>(10));
        for (int i = 0 ; i< 10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        shareResource.myProd();
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
                        shareResource.myConsumer();
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