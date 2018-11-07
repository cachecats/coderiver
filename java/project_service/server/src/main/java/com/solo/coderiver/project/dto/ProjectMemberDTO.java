package com.solo.coderiver.project.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectMemberDTO implements Serializable {

    private static final long serialVersionUID = 6262570541994755272L;

    private String userId;

    private String userName;

    private String userAvatar;

    private Integer userRole;

    private String roleName;

    public ProjectMemberDTO() {
    }

    public ProjectMemberDTO(String userId, String userName, String userAvatar, Integer userRole, String roleName) {
        this.userId = userId;
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.userRole = userRole;
        this.roleName = roleName;
    }
}
