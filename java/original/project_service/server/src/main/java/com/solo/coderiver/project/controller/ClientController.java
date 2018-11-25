package com.solo.coderiver.project.controller;

import com.solo.coderiver.project.common.ProjectInfoOutput;
import com.solo.coderiver.project.dataobject.ProjectInfo;
import com.solo.coderiver.project.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 给外部服务调用的接口
 */
@RestController
//@ApiIgnore
public class ClientController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/list")
    @ApiOperation(value = "通过用户id查询该用户参与的所有项目, 暴露给用户服务调用")
    public List<ProjectInfoOutput> findListByUserId(@RequestParam("userId") String userId) {
        return projectService.findProjectsByUserId(userId);
    }

    @GetMapping("/get")
    @ApiOperation(value = "通过项目id查询该项目, 暴露给用户服务调用")
    public ProjectInfoOutput findProjectByProjectId(@RequestParam("projectId") String projectId) {
        ProjectInfo projectInfo = projectService.findProjectByProjectId(projectId);
        ProjectInfoOutput output = new ProjectInfoOutput();
        BeanUtils.copyProperties(projectInfo, output);
        return output;
    }
}
