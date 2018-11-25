package com.solo.coderiver.project.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 新建项目提交的表单
 */
@Data
public class NewProjectForm {

    //创建项目的用户id
    @NotEmpty(message = "用户id不能为空")
    private String userId;

    //项目名字
    @NotEmpty(message = "项目名称不能为空")
    private String projectName;

    //项目简介
    private String projectIntroduce;

    //项目成员
    @NotEmpty(message = "团队配置不能为空")
    private List<ProjectMemberForm> members;

    //创建者的角色
    @NotNull(message = "创建者角色不能为空")
    private Integer ownerRole;

    //项目难度
    @NotNull(message = "项目难度不能为空")
    private Float projectDifficulty;

    //项目开始时间
    @NotEmpty(message = "项目开始时间不能为空")
    private String projectStartDate;

    //项目结束时间
    @NotEmpty(message = "项目结束时间不能为空")
    private String projectEndDate;

    //项目封面
    private String projectAvatar;

    //项目截图
    private String projectPictures;

    //项目类型
    @NotNull(message = "项目类型不能为空")
    private Integer categoryType;

    //项目类型名字
    @NotEmpty(message = "项目类型不能为空")
    private String categoryName;

}
