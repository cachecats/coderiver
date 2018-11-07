package com.solo.coderiver.user.dto;

import lombok.Data;

@Data
public class TeamInfoDTO {

    //团队id
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
