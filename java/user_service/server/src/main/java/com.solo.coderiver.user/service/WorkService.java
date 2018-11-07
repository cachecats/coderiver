package com.solo.coderiver.user.service;

import com.solo.coderiver.user.dataobject.WorkExperience;

import java.util.List;

public interface WorkService {

    List<WorkExperience> findByUserId(String userId);

    WorkExperience save(WorkExperience experience);

}
