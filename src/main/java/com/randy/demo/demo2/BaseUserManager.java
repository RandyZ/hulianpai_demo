package com.randy.demo.demo2;

/**
 * Create with project demo
 *
 * @author randy
 * @date 2019/9/1 13:10
 */
public abstract class BaseUserManager implements IUser {
    private String userId;
    private String userName;

    @Override
    public String userName() {
        return userName;
    }

    @Override
    public void forbidUser() {
        System.out.printf("用户%s被禁用了，id是%s", userName, userId);
    }
}
