package com.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalTest {
    private static  final  String KEY="key";
    private static final ThreadLocal<Connection> threadSession = new ThreadLocal<Connection>();
    public static void main(String[] args) {
        List<String> lst=new ArrayList<>();
        String cc="";
       new FinalTest().isValidate(lst);
       cc=String.join("\r\n",lst);
       System.out.println(cc);

       List<String> lstSort=new ArrayList<>();
       lstSort.add("lock_0001");
        lstSort.add("lock_0021");
        lstSort.add("lock_0011");
        lstSort.add("lock_0010");

        Collections.sort(lstSort);
        lstSort.stream().forEach(e->System.out.println(e));
    }

    public Boolean isValidate(List<String> lst){
        lst.add("aa");
        lst.add("bb");
        return true;
    }
}
