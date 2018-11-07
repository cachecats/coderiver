package com.solo.coderiver.project.service.impl;

import com.solo.coderiver.project.dataobject.ProjectPicture;
import com.solo.coderiver.project.repository.ProjectPictureRepository;
import com.solo.coderiver.project.service.ProjectPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectPictureServiceImpl implements ProjectPictureService {

    @Autowired
    ProjectPictureRepository repository;

    @Override
    public List<ProjectPicture> saveAll(List<ProjectPicture> pictureList) {
        return repository.saveAll(pictureList);
    }

    @Override
    public List<ProjectPicture> findByProjectId(String projectId) {
        return repository.findByProjectId(projectId);
    }
}
