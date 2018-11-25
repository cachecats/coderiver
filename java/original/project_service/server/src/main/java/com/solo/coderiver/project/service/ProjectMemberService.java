package com.solo.coderiver.project.service;

import com.solo.coderiver.project.dataobject.ProjectMember;

import java.util.List;

public interface ProjectMemberService {

    /**
     * 通过项目id查看团队成员
     *
     * @param projectId
     * @return
     */
    List<ProjectMember> findMembersByProjectId(String projectId);

    /**
     * 保存项目成员列表
     *
     * @param memberList
     * @return
     */
    List<ProjectMember> saveAll(List<ProjectMember> memberList);
}
