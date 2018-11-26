package com.solo.coderiver.project.VO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProjectInfoVO {

    //项目id
    private String projectId;

    //项目名字
    private String projectName;

    //项目封面图片
    private String projectAvatar;

    //项目难度
    private Float projectDifficulty;

    //项目类型
    private Integer categoryType;

    //项目类型名字
    private String categoryName;

    //项目进度（0，1，2，3表示各个阶段）
    private Integer projectProgress;

    //项目状态（0：开发中，1完成，2失败）
    private Integer projectStatus;

    //项目简介
    private String projectIntroduce;

    //项目创建者id
    private String projectCreatorId;

    //项目所属团队id
    private String teamId;

    //项目开始时间
    private Date projectStartDate;

    //项目结束时间
    private Date projectEndDate;

    //团队阵容
    private List<MemberVO> memberList;
}
