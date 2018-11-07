package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.dataobject.TeamApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamApplyRepository extends JpaRepository<TeamApply, Integer> {

    List<TeamApply> findByProjectCreatorId(String projectCreatorId);

    List<TeamApply> findByApplicantsId(String applicantsId);

}
