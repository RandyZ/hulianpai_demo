package com.randy.homework.result;

/**
 * Created with demo.
 * Date: 2020/8/30.
 * Time: 7:55 下午.
 *
 * @author randy.
 */
public interface Person {
    /**
     * 说话能力
     *
     * @param content
     */
    default void speek(String content) {
        System.out.println("发出声音：" + content);
    }

}
