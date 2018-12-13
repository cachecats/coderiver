package com.solo.coderiver.project.service.mybatis;

import com.solo.coderiver.project.dataobject.ProjectCategory;
import com.solo.coderiver.project.mapper.ProjectCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: solo
 * @Date: 2018/12/12 2:48 PM
 * @Version 1.0
 */
@Service
public class ProjectCategoryService {

    @Autowired
    ProjectCategoryMapper mapper;

    public Integer insert(ProjectCategory category){
        return mapper.insert(category);
    }

    public Integer deleteByType(Integer type){
        return mapper.deleteByType(type);
    }

    public Integer update(ProjectCategory category){
        return mapper.updateByType(category);
    }

    public ProjectCategory findByType(Integer type){
        return mapper.selectByType(type);
    }
}
