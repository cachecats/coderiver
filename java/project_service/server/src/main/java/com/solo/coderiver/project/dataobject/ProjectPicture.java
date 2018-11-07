package com.solo.coderiver.project.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ProjectPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pictureId;

    //项目id
    private String projectId;

    //图片url地址
    private String pictureUrl;

    public ProjectPicture() {
    }

    public ProjectPicture(String projectId, String pictureUrl) {
        this.projectId = projectId;
        this.pictureUrl = pictureUrl;
    }
}
