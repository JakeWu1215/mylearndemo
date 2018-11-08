package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForOrForeach {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("恭喜你");
        list.add("欢迎你");
        list.add("天气好呀");
      list.add("abc");
        list.add("世界真大真大");
        list.add("面试加油，看好你");

        question(list);
        //question1(list);
        System.out.println(list);
    }
    public static void question(List<String> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).length()==3){
                list.remove(list.get(i));
                i=0;
            }
        }
//        for (String str:list) {
//            if (str.length()==3)
//                list.remove(str);
//        }
    }
    public static void question1(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.length() == 3)
                iterator.remove();
        }
    }
}
