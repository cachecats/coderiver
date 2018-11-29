package com.solo.coderiver.project.VO;

import com.solo.coderiver.project.dto.ProjectInfoDTO;
import com.solo.coderiver.project.dto.ProjectMemberDTO;
import com.solo.coderiver.project.dto.ProjectPictureDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 获取项目详情接口的返回数据
 */
@Data
public class ProjectDetailVO implements Serializable {

    private static final long serialVersionUID = -4170700423123903347L;

    //项目信息
    private ProjectInfoDTO projectInfoDTO;

    //团队阵容
    private List<ProjectMemberDTO> members;

    //项目截图
    private List<ProjectPictureDTO> pictures;


}
