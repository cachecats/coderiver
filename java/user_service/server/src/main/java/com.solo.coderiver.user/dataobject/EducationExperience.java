package com.solo.coderiver.user.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class EducationExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //用户id
    private String userId;

    //学校名字
    private String schoolName;

    //专业
    private String major;

    //学位
    private String degree;

    //备注。获奖记录等
    private String comment;

    //开始日期
    private Date startDate;

    //结束日期
    private Date endDate;

    public EducationExperience() {
    }
}
