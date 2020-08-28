package com.randy.demo.demo2;

/**
 * Create with project demo
 *
 * @author randy
 * @date 2019/9/1 13:09
 */

public interface IUser {
    /**
     * 用户名称
     *
     * @return
     */
    String userName();

    /**
     * 用户身份
     *
     * @return
     */
    String userRole();

    /**
     * 禁用用户
     */
    void forbidUser();

    /**
     * 计算用户薪水
     *
     * @return
     */
    Integer calcSalary();
}
