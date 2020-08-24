package com.randy.demo.demo2;

/**
 * Create with project demo
 *
 * @author randy
 * @date 2019/9/1 13:11
 */
public class UserDeptManager extends UserManager {
    public String userRole() {
        return "部门管理员";
    }

    public Integer calcSalary() {
        return 12;
    }
}
