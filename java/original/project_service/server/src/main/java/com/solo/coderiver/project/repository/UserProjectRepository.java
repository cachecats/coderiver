package com.solo.coderiver.project.repository;

import com.solo.coderiver.project.dataobject.UserProjectRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProjectRepository extends JpaRepository<UserProjectRelation, Integer> {

    List<UserProjectRelation> findByProjectId(String projectId);

    List<UserProjectRelation> findByUserId(String userId);
}
