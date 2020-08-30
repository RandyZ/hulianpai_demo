package com.randy.designmode.builder;

import com.randy.homework.result.Student;
import com.randy.homework.result.Teacher;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created with demo.
 * Date: 2020/8/30.
 * Time: 8:50 下午.
 *
 *
 *
 * @author randy.
 */
@Getter
@Setter
@Builder
public class ClassDto {
    private Teacher teacher;
    private Student majorStudent;
    private List<Student> allStudent;


    public Optional<Student> peek(Predicate<Student> predicate) {
        return allStudent.stream().filter(predicate).findFirst();
    }
}
