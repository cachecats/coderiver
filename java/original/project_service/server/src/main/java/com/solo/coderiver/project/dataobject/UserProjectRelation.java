package com.solo.coderiver.project.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class UserProjectRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //用户id
    private String userId;

    //项目id
    private String projectId;

    public UserProjectRelation() {
    }

    public UserProjectRelation(String userId, String projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }
}
