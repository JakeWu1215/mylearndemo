package com.controller;

import com.Model.Student;

public class TestTs {
    public static void main(String[] args) {
        Student s=new Student();
        s.setTs(1537178811);

        String aa=s.getUpdateDesc();
        System.out.println(s.getUpdateDesc());
    }
}
