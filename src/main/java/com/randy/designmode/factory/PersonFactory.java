package com.randy.designmode.factory;

import com.randy.homework.result.Person;
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
public abstract class PersonFactory {

//    public static <T extends Person> T createPerson(Class<T> clazz) {
//        try {
//            return clazz.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    private static PersonFactoryStudentImpl factoryStudent;
    private static PersonFactoryTeacherImpl factoryTeacher;

    private static PersonFactoryStudentImpl getFactoryStudent(){
        if (factoryStudent == null) {
            factoryStudent = new PersonFactoryStudentImpl();
        }
        return factoryStudent;
    }

    private static PersonFactoryTeacherImpl getFactoryTeacher(){
        if (factoryTeacher == null) {
            factoryTeacher = new PersonFactoryTeacherImpl();
        }
        return factoryTeacher;
    }

    public static <T extends PersonFactory> T getFactory(Class<? extends Person> clazz) {
        if (clazz.equals(clazz)) {
            return (T) getFactoryStudent();
        } else {
            return (T) getFactoryTeacher();
        }
    }

    abstract Optional<Student> createStuden(String number);

    abstract Optional<Teacher> createTeacher(List<Student> studentList);

}
