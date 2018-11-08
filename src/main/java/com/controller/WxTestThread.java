package com.controller;

public class WxTestThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":hello threadPool");
    }
}
