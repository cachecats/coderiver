package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.dataobject.WorkExperience;
import com.solo.coderiver.user.enums.ResultEnum;
import com.solo.coderiver.user.exception.UserException;
import com.solo.coderiver.user.repository.WorkExperienceRepository;
import com.solo.coderiver.user.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkExperienceRepository repository;

    @Override
    public List<WorkExperience> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    @Transactional
    public WorkExperience save(WorkExperience experience) {
        WorkExperience result = repository.save(experience);
        if (result == null) {
            throw new UserException(ResultEnum.SAVE_WORK_EXPERIENCE_FAIL);
        }
        return result;
    }
}
