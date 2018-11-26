package com.solo.coderiver.project.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String projectId;

    private String projectName;

    private String projectAvatar;

    private String userId;

    private String userName;

    private String userAvatar;

    private Integer userRole;

    private String roleName;

    private Integer status;

    public ProjectMember() {
    }

    public ProjectMember(String projectId, String projectName, String projectAvatar, Integer userRole, String roleName, Integer status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectAvatar = projectAvatar;
        this.userRole = userRole;
        this.roleName = roleName;
        this.status = status;
    }
}
