package com.solo.coderiver.project.mapper;

import com.solo.coderiver.project.dataobject.ProjectCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: solo
 * @Date: 2018/12/12 2:30 PM
 * @Version 1.0
 */
@Mapper
public interface ProjectCategoryMapper {

    int insert(ProjectCategory category);

    int deleteByType(Integer type);

    int updateByType(ProjectCategory category);

    ProjectCategory selectByType(Integer type);
}
