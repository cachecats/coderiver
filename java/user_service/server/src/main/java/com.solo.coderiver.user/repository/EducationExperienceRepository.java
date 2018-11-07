package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.dataobject.EducationExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationExperienceRepository extends JpaRepository<EducationExperience, Integer> {

    List<EducationExperience> findByUserId(String userId);
}
