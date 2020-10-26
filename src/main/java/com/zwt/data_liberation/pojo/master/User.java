package com.zwt.data_liberation.pojo.master;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 10:17
 */
public class User {
    private Long id;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
