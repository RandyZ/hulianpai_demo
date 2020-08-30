package com.randy.designmode.builder;

import com.randy.designmode.factory.ScoreStragty;
import com.randy.homework.result.Student;

import java.util.Collections;
import java.util.function.Predicate;

/**
 * Created with demo.
 * Date: 2020/8/30.
 * Time: 8:23 下午.
 *
 * @author randy.
 */
public class MainClass {
    //    private final static Predicate<Student> BY_NUMBER = student -> StringUtils.equals(student.getNumber(), "123");
    private final static Predicate<Student> BY_SCORE_GOOD = student -> student.getScore() > 90;
    private final static Predicate<Student> BY_SCORE_NORMAL = student -> student.getScore() >= 60;
    private final static Predicate<Student> BY_SCORE_BAD = student -> student.getScore() < 60;


    public static void main(String[] args) {
        // 1
        ClassDto classDto = new ClassDto(null, null, Collections.emptyList());

        // 2
//        classDto = new ClassDto();
//        classDto.setTeacher(null);
//        classDto.setMajorStudent(null);
//        classDto.setAllStudent(Collections.emptyList());

        ClassDto.ClassDtoBuilder builder = ClassDto.builder();

        ClassDto dto = ClassDto.builder().teacher(null).majorStudent(null).allStudent(Collections.emptyList()).build();

        ScoreStragty scoreStragty = ScoreStragty.BY_SCORE_GOOD;

        dto.peek(student ->  scoreStragty.testStundent(student))
                .ifPresent(student -> {

                });
    }
}
