package com.solo.coderiver.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@ApiModel("教育经历前后端交互对象")
public class EducationExperienceDTO implements Serializable {

    private static final long serialVersionUID = 8178627614316234608L;

    @ApiModelProperty(value = "教育经历主键id（自增）,新增时不用传，修改时必须传", required = false)
    private Integer id;

    //用户id
    @ApiModelProperty(value = "用户id", required = true)
    @NotEmpty(message = "用户id不能为空")
    private String userId;

    //学校名字
    @ApiModelProperty(value = "学校名字", required = true)
    @NotEmpty(message = "学校名字不能为空")
    private String schoolName;

    //专业
    @ApiModelProperty(value = "专业", required = true)
    @NotEmpty(message = "专业不能为空")
    private String major;

    //学位
    @ApiModelProperty(value = "学位（专科、本科、硕士、博士等）", required = true)
    @NotEmpty(message = "学位不能为空")
    private String degree;

    //备注。获奖记录等
    @ApiModelProperty(value = "备注。获奖记录等", required = false)
    private String comment;

    //开始日期
    @ApiModelProperty(value = "经历开始日期", required = true)
    @NotEmpty(message = "开始日期不能为空")
    private String startDate;

    //结束日期
    @ApiModelProperty(value = "经历结束日期", required = true)
    @NotEmpty(message = "结束日期不能为空")
    private String endDate;
}
