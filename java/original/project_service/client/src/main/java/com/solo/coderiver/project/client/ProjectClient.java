package com.solo.coderiver.project.client;

import com.solo.coderiver.project.common.ProjectInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "project")
public interface ProjectClient {

    @GetMapping("/project/list")
    List<ProjectInfoOutput> findProjectsByUserId(@RequestParam("userId") String userId);

    @GetMapping("/project/get")
    ProjectInfoOutput findProjectByProjectId(@RequestParam("projectId") String projectId);
}
