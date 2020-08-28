package com.randy.demo;

import java.util.Optional;

/**
 * Created with demo.
 * Date: 2020/8/26.
 * Time: 9:08 下午.
 *
 * @author randy.
 */
public class Demo5 {
    public static void main(String[] args) {
        Optional<String> ret = optString(null);

        Optional<Integer> ret1 = ret.map(s -> Integer.parseInt(s));
        // 1. 有值的时候直接消费
        ret1.ifPresent(integer -> {
            // TODO: 2020/8/26  更新数据
            integer.longValue();
        });
        // 2.
        if (ret1.isPresent()) {
            // TODO: 2020/8/26 log/////
        } else {

        }

    }

    public static Optional<String> optString(String param) {
//        param == null ? null :param + 1
        if (param == null) {
            return Optional.empty();
        } else {
            return Optional.of(param + 1);
        }
    }
}
