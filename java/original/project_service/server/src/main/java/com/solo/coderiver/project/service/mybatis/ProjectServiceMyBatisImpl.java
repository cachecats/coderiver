package com.solo.coderiver.project.service.mybatis;

import com.solo.coderiver.project.dataobject.ProjectInfo;
import com.solo.coderiver.project.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: solo
 * @Date: 2018/12/7 3:33 PM
 * @Version 1.0
 */
@Service
public class ProjectServiceMyBatisImpl{

    @Autowired
    ProjectMapper projectMapper;

    /**
     * 通过id查询项目
     * @param projectId
     * @return
     */
    public ProjectInfo findProjectByProjectId(String projectId) {
        ProjectInfo result = projectMapper.findProjectById(projectId);
        return result;
    }

    /**
     * 新建项目
     * @param info
     * @return
     */
    public Integer insertProject(ProjectInfo info){
        return projectMapper.insertProject(info);
    }

    /**
     * 更新项目名字
     * @param id
     * @param name
     * @return
     */
    public Integer updateProjectName(String id, String name){
       return projectMapper.updateProjectName(id, name);
    }

    /**
     * 通过id删除项目
     * @param id
     * @return
     */
    public Integer deleteProject(String id){
        return projectMapper.deleteProject(id);
    }

}
