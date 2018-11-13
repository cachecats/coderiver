package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.dataobject.EducationExperience;
import com.solo.coderiver.user.enums.ResultEnum;
import com.solo.coderiver.user.exception.UserException;
import com.solo.coderiver.user.repository.EducationExperienceRepository;
import com.solo.coderiver.user.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    EducationExperienceRepository repository;

    @Override
    public List<EducationExperience> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    @Transactional
    public EducationExperience save(EducationExperience experience) {
        EducationExperience result = repository.save(experience);
        if (result == null) {
            throw new UserException(ResultEnum.SAVE_EDUCATION_EXPERIENCE_FAIL);
        }
        return result;
    }
}
