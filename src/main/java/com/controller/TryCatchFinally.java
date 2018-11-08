package com.controller;

public class TryCatchFinally {
    public static void main(String[] args) {
        boolean flag=getFlag();
        System.out.println(flag);
        System.out.println(getSum());
    }
    private static boolean getFlag(){
        try{
            return true;
        }catch (Exception ex){
            return  true;
        }finally {
            return false;
        }
    }
    private static Integer getSum(){
        Integer aa=5;
        try{
            aa=6;
            aa=aa-2;
            return aa;
        }catch (Exception ex){
            aa=7;
            return  aa;
        }finally {
            aa=8;
           // return aa;
        }
    }
}
