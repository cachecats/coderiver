package com.solo.coderiver.project.repository;

import com.solo.coderiver.project.ProjectApplicationTests;
import com.solo.coderiver.project.dataobject.ProjectPicture;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectPictureRepositoryTest extends ProjectApplicationTests {

    @Autowired
    ProjectPictureRepository repository;

    @Test
    public void save() {
        ProjectPicture picture = new ProjectPicture("1539259206662512790", "http://hahhaha.png");
        ProjectPicture save = repository.save(picture);
        Assert.assertNotNull(save);
    }

    @Test
    public void saveAll() {
        List<ProjectPicture> list = Arrays.asList(
                new ProjectPicture("1540980841377681170", "1.png"),
                new ProjectPicture("1540980841377681170", "2.png")
        );
        List<ProjectPicture> result = repository.saveAll(list);
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findByProjectId() {
        List<ProjectPicture> list = repository.findByProjectId("1539259206662512790");
        Assert.assertNotEquals(0, list.size());
    }
}