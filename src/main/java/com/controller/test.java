package com.controller;

import com.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test {

    public static void main(String[] args) {
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.postForLocation("http://192.168.103.94:8080/dkserver/bankcardModify","123");
        List<Student> stuLst = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1);
        s1.setAge(2);
        s1.setSno("001");
        s1.setName("zaaa");
        stuLst.add(s1);

        Student s2 = new Student();
        s2.setId(2);
        s2.setAge(5);
        s2.setSno("002");
        s2.setName("abzcabbb");
        stuLst.add(s2);

        Student s3 = new Student();
        s3.setId(3);
        s3.setAge(3);
        s3.setSno("003");
        s3.setName("abzabbbccc");
        stuLst.add(s3);
        Collections.sort(stuLst);
        Collections.sort(stuLst, new Comparator<Student>() {
            //根据是字符串排序
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        Collections.sort(stuLst, new Comparator<Student>() {
            //根据数值类型排序
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });


        for (Student s : stuLst) {
            System.out.println(s.getAge());
        }

    }
}
