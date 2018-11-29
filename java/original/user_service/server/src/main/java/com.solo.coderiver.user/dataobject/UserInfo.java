package com.solo.coderiver.user.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;


@Data
@Entity
@DynamicUpdate
public class UserInfo {

    @Id
    private String id;

    //用户昵称
    private String name;

    //密码
    private String password;

    //token. 改为存储到 Redis 中，不再在数据库中存
//    private String token;

    //性别。0未知 1男 2女
    private Integer sex;

    //电话
    private String tel;

    //邮箱
    private String email;

    //头像
    private String avatar;

    //微信的 openid
    private String openid;

    //qq的 id
    private String qqId;

    //用户角色。0未知
    private Integer role;

    //城市
    private String city;

    //工作经验。0:在校生 1:0年 2:1-2年 3:3-5年 4:5-10年 5:10年+
    private Integer experience;

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

    //点赞数量
    private Integer likeNum;

    //个人简介
    private String introduce;

    public UserInfo() {
    }
}
