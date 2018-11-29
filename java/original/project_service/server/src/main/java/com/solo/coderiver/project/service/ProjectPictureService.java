package com.solo.coderiver.project.service;

import com.solo.coderiver.project.dataobject.ProjectPicture;

import java.util.List;

/**
 * 项目截图相关服务
 */
public interface ProjectPictureService {

    /**
     * 保存多个 ProjectPicture 对象
     *
     * @param pictureList
     * @return
     */
    List<ProjectPicture> saveAll(List<ProjectPicture> pictureList);

    /**
     * 根据项目id查询该项目的所有截图
     *
     * @param projectId
     * @return
     */
    List<ProjectPicture> findByProjectId(String projectId);
}
