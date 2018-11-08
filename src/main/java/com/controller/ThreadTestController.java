package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
public class ThreadTestController {
    @Autowired
    @Qualifier("myTaskExecutor")
    private ThreadPoolTaskExecutor myTaskExecutor;
    @Autowired
    private CustomBean customBean;
    @GetMapping("/threadTest/test")
    public  void thread() {
        //无返回值
//        myTaskExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("123");
//            }
//        });
//        System.out.println("fsfs");
        //有返回值
        Future<String> result= myTaskExecutor.submit(new Callable<String>() {
         @Override
         public String call() throws Exception {
             return "aaa";
         }
     });
        try {
          String aaa=  result.get(10,TimeUnit.SECONDS);
            System.out.println(aaa);
        }catch (Exception ex){
            ex.printStackTrace();
        }
       Future<String> result1=myTaskExecutor.submit(customBean);
        try {
            String aaaaa=result1.get();
            System.out.println(aaaaa);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
