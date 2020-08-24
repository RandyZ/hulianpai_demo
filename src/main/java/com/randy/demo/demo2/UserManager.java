package com.randy.demo.demo2;

/**
 * Create with project demo
 *
 * @author randy
 * @date 2019/9/1 13:10
 */
public abstract class UserManager implements IUser {
    private String userId;
    private String userName;

    public String userName() {
        return userName;
    }

    public void forbidUser() {
        System.out.printf("用户%s被禁用了，id是%s", userName, userId);
    }
}
