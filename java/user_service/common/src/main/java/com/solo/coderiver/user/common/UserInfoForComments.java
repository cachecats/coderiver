package com.solo.coderiver.user.common;

import java.io.Serializable;

/**
 * 为评论模块准备的用户信息，评论模块只查用户头像，所以只返回 id 和头像
 */
public class UserInfoForComments implements Serializable {

    private static final long serialVersionUID = -2990181938506795811L;

    //用户id
    private String id;

    //用户头像
    private String avatar;

    public UserInfoForComments() {
    }

    public UserInfoForComments(String id, String avatar) {
        this.id = id;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserInfoForComments{" +
                "id='" + id + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
