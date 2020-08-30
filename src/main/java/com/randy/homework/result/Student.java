package com.randy.homework.result;

import lombok.Data;

/**
 * Created with demo.
 * Date: 2020/8/30.
 * Time: 7:57 下午.
 *
 * @author randy.
 */
@Data
public class Student implements Person {
    private String number;
    private Integer score;

    public Student(String number) {
        this.number = number;
    }


    public void tell(String content) {
        speek(content);
    }
}
