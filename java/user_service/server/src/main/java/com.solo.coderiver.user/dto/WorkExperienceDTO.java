package com.solo.coderiver.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class WorkExperienceDTO implements Serializable {

    private static final long serialVersionUID = -8281459247687580403L;

    @ApiModelProperty(value = "工作经验主键id，自增。新增时不用传，修改时必须传", required = false)
    private Integer id;

    //用户id
    @ApiModelProperty(value = "用户id", required = true)
    @NotEmpty
    private String userId;

    //公司名字
    @ApiModelProperty(value = "公司名字", required = true)
    @NotEmpty
    private String companyName;

    //职位
    @ApiModelProperty(value = "职位", required = true)
    @NotEmpty
    private String position;

    //备注。工作职责等
    @ApiModelProperty(value = "备注。工作职责等", required = true)
    @NotEmpty
    private String comment;

    //开始日期
    @ApiModelProperty(value = "开始日期", required = true)
    @NotEmpty
    private String startDate;

    //结束日期
    @ApiModelProperty(value = "结束日期", required = true)
    @NotEmpty
    private String endDate;
}
