package com.solo.coderiver.project.repository;

import com.solo.coderiver.project.dataobject.ProjectCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectCategoryRepository extends JpaRepository<ProjectCategory, Integer> {

    ProjectCategory findByCategoryType(Integer type);
}
