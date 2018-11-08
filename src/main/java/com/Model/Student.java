package com.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements  Comparable<Student> {
    private int id;
    private int age;
    private String name;
    private String sno;
    private long ts;
    private String updateDesc;

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getUpdateDesc() {
        if(ts!=0){
            //ts=ts*1000;
            long tsTemp=ts*1000;
            SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date nowTime = new Date(tsTemp);
            String retStrFormatNowDate = sdFormatter.format(nowTime);
            return  retStrFormatNowDate;
        }
        return updateDesc;
    }

    public void setUpdateDesc(String updateDesc) {
        this.updateDesc = updateDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
    @Override
   public int compareTo(Student student){
        return this.getAge()-student.getAge();
    }
}
