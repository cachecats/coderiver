package com.solo.coderiver.project.service.impl;

import com.solo.coderiver.project.dataobject.ProjectMember;
import com.solo.coderiver.project.repository.ProjectMemberRepository;
import com.solo.coderiver.project.service.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    @Autowired
    ProjectMemberRepository repository;

    @Override
    public List<ProjectMember> findMembersByProjectId(String projectId) {
        return repository.findByProjectId(projectId);
    }

    @Override
    public List<ProjectMember> saveAll(List<ProjectMember> memberList) {
        return repository.saveAll(memberList);
    }
}
