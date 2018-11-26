package com.solo.coderiver.project.repository;

import com.solo.coderiver.project.dataobject.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Integer> {

    List<ProjectMember> findByProjectId(String projectId);
}
