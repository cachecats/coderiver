package com.solo.coderiver.project.repository;

import com.solo.coderiver.project.dataobject.ProjectInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectInfoRepository extends JpaRepository<ProjectInfo, String> {

    ProjectInfo findByProjectId(String projectId);

    List<ProjectInfo> findByProjectIdIn(List<String> projectIds);

    Page<ProjectInfo> findByCategoryType(Pageable pageable, Integer type);

    Page<ProjectInfo> findByProjectProgress(Pageable pageable, Integer progress);

    Page<ProjectInfo> findByCategoryTypeAndProjectProgress(Pageable pageable, Integer type, Integer progress);
}
