package com.randy.designmode.factory;

import com.randy.homework.result.Student;
import com.randy.homework.result.Teacher;

import java.util.List;
import java.util.Optional;

/**
 * Created with demo.
 * Date: 2020/8/30.
 * Time: 8:20 下午.
 *
 * @author randy.
 */
public class PersonFactoryStudentImpl extends PersonFactory {

    @Override
    Optional<Student> createStuden(String number) {
        return Optional.of(new Student(number));
    }

    @Override
    Optional<Teacher> createTeacher(List<Student> studentList) {
        return Optional.empty();
    }
}
