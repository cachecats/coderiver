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
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //用户id
    private String userId;

    //公司名字
    private String companyName;

    //职位
    private String position;

    //备注。工作职责等
    private String comment;

    //开始日期
    private Date startDate;

    //结束日期
    private Date endDate;

    public WorkExperience() {
    }
}
