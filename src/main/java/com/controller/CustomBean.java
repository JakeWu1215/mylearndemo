package com.controller;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.Callable;
@Component
@Scope("prototype")
public class CustomBean implements Callable<String> ,Serializable {


    @Override
    public String call() throws Exception {
String ss=Thread.currentThread().getName()+":hello threadPool";
        return ss;
    }
}
