package com.randy.designmode.factory;

import com.randy.homework.result.Student;

import java.util.Collections;

/**
 * Created with demo.
 * Date: 2020/8/30.
 * Time: 8:23 下午.
 *
 * @author randy.
 */
public class MainClass {
    public static void main(String[] args) {
//        Student student = PersonFactory.createPerson(Student.class);
//        PersonFactoryStudentImpl factoryStudent = PersonFactory.getFactory(Student.class);

        PersonFactory.<PersonFactoryStudentImpl>getFactory(Student.class)
                .createStuden("123")
                .ifPresent(student -> student.tell("Stundent 123"));

    }
}
