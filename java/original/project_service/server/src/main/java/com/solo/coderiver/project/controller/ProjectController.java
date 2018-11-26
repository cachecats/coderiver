package com.solo.coderiver.project.controller;

import com.solo.coderiver.project.VO.ProjectDetailVO;
import com.solo.coderiver.project.VO.ProjectInfoVO;
import com.solo.coderiver.project.VO.ResultVO;
import com.solo.coderiver.project.enums.ResultEnums;
import com.solo.coderiver.project.exception.ProjectException;
import com.solo.coderiver.project.form.NewProjectForm;
import com.solo.coderiver.project.service.ProjectService;
import com.solo.coderiver.project.utils.ResultVOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@Api(description = "项目相关接口")
@Slf4j
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/test")
    @ApiOperation("测试")
    public String test() {
        return "ok";
    }

    @PostMapping("/save")
    @ApiOperation("保存项目，新建项目接口")
    public ResultVO saveProject(@Valid NewProjectForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【新建项目】参数错误，NewProjectForm={}", form.toString());
            throw new ProjectException(ResultEnums.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        projectService.saveProject(form);
        return ResultVOUtils.success();
    }

    @GetMapping("/projects")
    @ApiOperation("获取分页项目列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "项目分类", required = false),
            @ApiImplicitParam(name = "progress", value = "项目进度", required = false),
            @ApiImplicitParam(name = "sort", value = "排序方式", required = false),
            @ApiImplicitParam(name = "page", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页的大小"),
    })
    public ResultVO getProjectList(@RequestParam(value = "type", required = false) Integer type,
                                   @RequestParam(value = "progress", required = false) Integer progress,
                                   @RequestParam(value = "sort", required = false) Integer sort,
                                   @RequestParam("page") Integer page,
                                   @RequestParam("size") Integer size) {
        List<ProjectInfoVO> projectList = Collections.emptyList();
        if (type == null && progress == null) {
            projectList = projectService.getProjectList(page, size, sort);
        } else if (type == null) {
            projectList = projectService.getProjectListByProjectProgress(page, size, progress, sort);
        } else if (progress == null) {
            projectList = projectService.getProjectListByCategoryType(page, size, type, sort);
        } else {
            projectList = projectService.getProjectListByTypeAndProgress(page, size, type, progress, sort);
        }
        return ResultVOUtils.success(projectList);
    }


    @GetMapping("/detail/{id}")
    @ApiOperation("获取项目详情")
    public ResultVO getProjectDetails(@PathVariable("id") String projectId) {
        ProjectDetailVO projectDetail = projectService.getProjectDetail(projectId);
        return ResultVOUtils.success(projectDetail);
    }


}
