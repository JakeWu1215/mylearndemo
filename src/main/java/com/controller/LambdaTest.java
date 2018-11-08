package com.controller;

import com.Model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {
    public static void main(String[] args) {
        String aa="Jake";
        Optional.ofNullable(aa).ifPresent(System.out::println);

        List<Student> students = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            Student stu = new Student();
            stu.setName("wdd"+i);
            students.add(stu);
        }

        List<Student> stu=students.stream().skip(2).limit(3)
                .sorted((p1,p2)->p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());

        stu.stream().forEach(e->System.out.println(e.getName()));

     List<String>  lst= stu.stream().map(p->p.getName().toUpperCase()).peek(p->System.out.println(p)).collect(Collectors.toList());

     stu.stream().peek(p->System.out.println(p.getName()+"test")).collect(Collectors.toList());


     students.stream()
     .forEach(p->System.out.println(p.getName()));
    }
}
