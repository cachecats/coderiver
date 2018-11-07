package com.solo.coderiver.user.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class UserTeamRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //用户id
    private String userId;

    //团队id
    private String teamId;

    public UserTeamRelation() {
    }

    public UserTeamRelation(String userId, String teamId) {
        this.userId = userId;
        this.teamId = teamId;
    }
}
