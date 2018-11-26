package com.solo.coderiver.user.service;

import com.solo.coderiver.user.dataobject.EducationExperience;

import java.util.List;

public interface EducationService {

    List<EducationExperience> findByUserId(String userId);

    EducationExperience save(EducationExperience experience);

}
