package com.solo.coderiver.project.service.mybatis;

import com.solo.coderiver.project.dataobject.ProjectMember;
import com.solo.coderiver.project.mapper.ProjectMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: solo
 * @Date: 2018/12/13 10:34 AM
 * @Version 1.0
 */
@Service
public class ProjectMemberServiceMyBatisImpl {

    @Autowired
    ProjectMemberMapper mapper;

    public List<ProjectMember> findByProjectId(String projectId){
        return mapper.selectByProjectId(projectId);
    }
}
