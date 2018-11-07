package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.dataobject.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer> {

    List<WorkExperience> findByUserId(String userId);
}
