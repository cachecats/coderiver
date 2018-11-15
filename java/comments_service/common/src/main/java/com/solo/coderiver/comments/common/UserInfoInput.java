package com.solo.coderiver.comments.common;

import java.io.Serializable;

/**
 * 接收的 userInfo
 */
public class UserInfoInput implements Serializable {

    private static final long serialVersionUID = 6737363429482036119L;

    //用户id
    private String id;

    //用户头像
    private String avatar;

    @Override
    public String toString() {
        return "UserInfoInput{" +
                "id='" + id + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
