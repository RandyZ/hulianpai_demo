package com.randy.designmode.factory;

import com.randy.homework.result.Student;

import java.util.function.Predicate;

/**
 * Created with demo.
 * Date: 2020/8/30.
 * Time: 9:45 下午.
 *
 * @author randy.
 */
public enum ScoreStragty {
    BY_SCORE_GOOD(student -> student.getScore() > 90),
    BY_SCORE_NORMAL(student -> student.getScore() >= 60),
    BY_SCORE_NORMA1L(student -> student.getScore() >= 50),
    BY_SCORE_BAD(student -> student.getScore() < 60);

    Predicate<Student> logic;

    ScoreStragty(Predicate<Student> logic) {
        this.logic = logic;
    }

    public boolean testStundent(Student student) {
        return logic.test(student);
    }
}
