package com.controller;

public class Test2 {
    public static void main(String[] args) {
        Integer aa=25;
        Integer bb=25;
        System.out.println(aa==bb);
        Integer cc=-128;
        Integer dd=-128;
        System.out.println(cc==dd);
        Integer ee=-129;
        Integer ff=-129;
        System.out.println(ee==ff);
        Integer gg=127;
        Integer ii=127;
        System.out.println(gg==ii);
        Integer kk=128;
        Integer hh=128;
        System.out.println(kk==hh);
        System.out.println("字符串比较:");
        String str1="abc";
        String str2="abc";
        String str3=new String("abc");
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1==str3);
    }
}
