package com.solo.coderiver.project.service;

import com.solo.coderiver.project.VO.ProjectDetailVO;
import com.solo.coderiver.project.VO.ProjectInfoVO;
import com.solo.coderiver.project.common.ProjectInfoOutput;
import com.solo.coderiver.project.dataobject.ProjectCategory;
import com.solo.coderiver.project.dataobject.ProjectInfo;
import com.solo.coderiver.project.dataobject.UserProjectRelation;
import com.solo.coderiver.project.form.NewProjectForm;

import java.util.List;

public interface ProjectService {

    /**
     * 通过项目 id 查询项目
     *
     * @param projectId
     * @return
     */
    ProjectInfo findProjectByProjectId(String projectId);

    /**
     * 保存或更新项目
     *
     * @param form
     */
    void saveProject(NewProjectForm form);

    /**
     * 保存或更新项目分类
     *
     * @param category
     * @return
     */
    ProjectCategory saveProjectCategory(ProjectCategory category);

    /**
     * 通过类别id查询类别
     *
     * @param type
     * @return
     */
    ProjectCategory findCategoryByCategoryType(Integer type);


    /**
     * 通过项目id查询用户-项目对应关系
     *
     * @param projectId
     * @return
     */
    List<UserProjectRelation> findRelationByProjectId(String projectId);


    /**
     * 通过用户id查询该用户参与的所有项目
     *
     * @param userId
     * @return
     */
    List<ProjectInfoOutput> findProjectsByUserId(String userId);

    /**
     * 获取全部项目列表（默认排序）
     *
     * @param page 当前页
     * @param size 每页大小
     * @param sort 排序方式
     * @return
     */
    List<ProjectInfoVO> getProjectList(Integer page, Integer size, Integer sort);

    /**
     * 查询指定项目类型的项目列表
     *
     * @param type 项目类型
     * @return
     */
    List<ProjectInfoVO> getProjectListByCategoryType(Integer page, Integer size, Integer type, Integer sort);

    /**
     * 通过项目进度分页查询项目列表
     *
     * @param progress
     * @return
     */
    List<ProjectInfoVO> getProjectListByProjectProgress(Integer page, Integer size, Integer progress, Integer sort);

    /**
     * 通过项目类型和项目进度组合分页查询项目
     *
     * @param type
     * @param progress
     * @return
     */
    List<ProjectInfoVO> getProjectListByTypeAndProgress(Integer page, Integer size, Integer type, Integer progress, Integer sort);

    /**
     * 根据项目id获取项目详情
     *
     * @param projectId
     * @return
     */
    ProjectDetailVO getProjectDetail(String projectId);

}
