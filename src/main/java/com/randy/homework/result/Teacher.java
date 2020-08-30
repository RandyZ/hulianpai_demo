package com.randy.homework.result;

import java.util.List;

/**
 * Created with demo.
 * Date: 2020/8/30.
 * Time: 7:56 下午.
 *
 * @author randy.
 */
public class Teacher implements Person {

    private List<Student> studentList;

    public Teacher(List<Student> studentList) {
        this.studentList = studentList;
    }


    public void teach(String teachContent) {
        speek(teachContent);
    }
}
