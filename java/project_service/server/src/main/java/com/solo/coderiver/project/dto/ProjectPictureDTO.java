package com.solo.coderiver.project.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectPictureDTO implements Serializable {

    private static final long serialVersionUID = -4413890825761370939L;

    //图片id
    private Integer pictureId;

    //项目id
    private String projectId;

    //图片url地址
    private String pictureUrl;


}
