package com.solo.coderiver.user.dto;

import com.solo.coderiver.user.enums.ExperienceEnum;
import com.solo.coderiver.user.enums.RoleEnum;
import com.solo.coderiver.user.enums.SexEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 人才广场列表对象
 */
@Data
public class TalentsListDTO implements Serializable {

    private static final long serialVersionUID = -1084672572198247131L;

    private String id;

    //用户昵称
    private String name;

    //性别。0未知 1男 2女
    private Integer sex = SexEnum.UNKNOW.getCode();

    //用户角色。0未知
    private Integer role = RoleEnum.UNKNOW.getCode();

    //点赞的数量
    private Integer likeNum;

    //头像
    private String avatar;

    //城市
    private String city;

    //工作经验。0:在校生 1:0年 2:1-2年 3:3-5年 4:5-10年 5:10年+
    private Integer experience = ExperienceEnum.STUDENT.getCode();

    //技能
    private String skill;

    //工作日空闲开始时间
    private String workdayStartTime;

    //工作日空闲结束时间
    private String workdayEndTime;

    //周末空闲开始时间
    private String weekendStartTime;

    //周末空闲结束时间
    private String weekendEndTime;

    //影响力
    private Integer influence;

    //个人简介
    private String introduce;

    private List<TeamInfoDTO> teams;

    //已完成的项目个数
    private Integer recordSuccess;

    //失败的项目个数
    private Integer recordFail;

    //开发中的项目个数
    private Integer recordDeveloping;


}
