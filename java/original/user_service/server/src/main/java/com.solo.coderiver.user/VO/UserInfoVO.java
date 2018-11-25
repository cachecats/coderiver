package com.solo.coderiver.user.VO;

import com.solo.coderiver.user.enums.ExperienceEnum;
import com.solo.coderiver.user.enums.RoleEnum;
import com.solo.coderiver.user.enums.SexEnum;
import lombok.Data;

import java.sql.Time;

@Data
public class UserInfoVO {

    private String id;

    //用户昵称
    private String name;

    //token
    private String token;

    //性别。0未知 1男 2女
    private Integer sex = SexEnum.UNKNOW.getCode();

    //邮箱
    private String email;

    //头像
    private String avatar;

    //用户角色。0未知
    private Integer role = RoleEnum.UNKNOW.getCode();

    //城市
    private String city;

    //工作经验。0:在校生 1:0年 2:1-2年 3:3-5年 4:5-10年 5:10年+
    private Integer experience = ExperienceEnum.STUDENT.getCode();

    //技能
    private String skill;

    //工作日空闲开始时间
    private Time workdayStartTime;

    //工作日空闲结束时间
    private Time workdayEndTime;

    //周末空闲开始时间
    private Time weekendStartTime;

    //周末空闲结束时间
    private Time weekendEndTime;

    //影响力
    private Integer influence;

    //点赞的数量
    private Integer likeNum;

    //个人简介
    private String introduce;
}
