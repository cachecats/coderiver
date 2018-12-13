package com.solo.coderiver.project.mapper;

import com.solo.coderiver.project.dataobject.ProjectMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: solo
 * @Date: 2018/12/12 6:48 PM
 * @Version 1.0
 */
@Mapper
public interface ProjectMemberMapper {

    List<ProjectMember> selectByProjectId(String projectId);
}
