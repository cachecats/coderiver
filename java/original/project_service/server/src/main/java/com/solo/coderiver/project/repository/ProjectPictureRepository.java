package com.solo.coderiver.project.repository;

import com.solo.coderiver.project.dataobject.ProjectPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectPictureRepository extends JpaRepository<ProjectPicture, Integer> {

    List<ProjectPicture> findByProjectId(String id);
}
