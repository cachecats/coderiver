package com.solo.coderiver.user.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class TeamInfo {

    //团队id
    @Id
    private String teamId;

    //团队名字
    private String teamName;

    //团队头像
    private String teamAvatar;

    //团队简介
    private String teamIntroduce;

    //团队创建者id
    private String teamCreatorId;


}
