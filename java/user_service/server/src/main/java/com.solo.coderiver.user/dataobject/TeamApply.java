package com.solo.coderiver.user.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;


/**
 * 组队申请实体类
 */
@Entity
@Data
public class TeamApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //项目id
    private String projectId;

    //项目名字
    private String projectName;

    //项目创建者id
    private String projectCreatorId;

    //申请者id
    private String applicantsId;

    //申请者名字
    private String applicantsName;

    //申请者头像
    private String applicantsAvatar;

    //申请者城市
    private String applicantsCity;

    //申请者经验
    private Integer applicantsExperience;

    //申请的角色（可以与申请者本身的角色不同）
    private Integer applicantsRole;

    //申请者工作日空闲开始时间
    private Time workdayStartTime;

    //申请者工作日空闲结束时间
    private Time workdayEndTime;

    //申请者周末空闲开始时间
    private Time weekendStartTime;

    //申请者周末空闲结束时间
    private Time weekendEndTime;

    //申请备注信息
    private String comments;

    //审核状态。0待审核，1已通过，2驳回
    private Integer auditStatus;

    //本条申请的状态。0删除，1正常
    private Integer status;

}
