package com.solo.coderiver.user.controller;

import com.solo.coderiver.project.client.ProjectClient;
import com.solo.coderiver.project.common.ProjectInfoOutput;
import com.solo.coderiver.user.VO.ResultVO;
import com.solo.coderiver.user.converter.User2TeamApplyConvetor;
import com.solo.coderiver.user.dataobject.TeamApply;
import com.solo.coderiver.user.dataobject.UserInfo;
import com.solo.coderiver.user.enums.ResultEnum;
import com.solo.coderiver.user.enums.TeamApplyAuditStatusEnum;
import com.solo.coderiver.user.enums.TeamApplyStatusEnum;
import com.solo.coderiver.user.exception.UserException;
import com.solo.coderiver.user.form.TeamApplyForm;
import com.solo.coderiver.user.service.TeamService;
import com.solo.coderiver.user.service.UserService;
import com.solo.coderiver.user.utils.ResultVOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/team")
@Api(description = "组队相关的接口")
public class TeamController {

    @Autowired
    ProjectClient projectClient;

    @Autowired
    UserService userService;

    @Autowired
    TeamService teamService;

    @PostMapping("/apply/save")
    @ApiOperation("保存组队申请")
    public ResultVO saveTeamApply(@Valid TeamApplyForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UserException(ResultEnum.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        //根据申请者id查询申请者信息
        UserInfo user = userService.findById(form.getUserId());
        if (user == null) {
            throw new UserException(ResultEnum.CANNOT_FIND_USER_INFO);
        }
        TeamApply teamApply = User2TeamApplyConvetor.user2TeamApply(user);

        //调用项目服务根据projectId查询项目详情
        ProjectInfoOutput project = projectClient.findProjectByProjectId(form.getProjectId());
        if (project == null) {
            throw new UserException(ResultEnum.CANNOT_FIND_PROJECT_INFO);
        }
        BeanUtils.copyProperties(project, teamApply);

        teamApply.setComments(form.getComments());
        teamApply.setApplicantsRole(form.getRole());
        teamApply.setAuditStatus(TeamApplyAuditStatusEnum.WAIT.getCode());
        teamApply.setStatus(TeamApplyStatusEnum.NORMAL.getCode());

        //保存
        TeamApply result = teamService.saveTeamApply(teamApply);
        return ResultVOUtils.success(result);
    }

    @GetMapping("/apply/list/applicants-id")
    @ApiOperation("通过申请者id查询组队申请列表")
    public ResultVO getTeamApplyByApplicantsId(@RequestParam("applicantsId") String applicantsId) {
        List<TeamApply> list = teamService.findTeamApplyByApplicantsId(applicantsId);
        return ResultVOUtils.success(list);
    }

    @GetMapping("/apply/list/creator-id")
    @ApiOperation("通过项目创建者id查询组队申请列表")
    public ResultVO getTeamApplyByProjectCreatorId(@RequestParam("projectCreatorId") String projectCreatorId) {
        List<TeamApply> list = teamService.findTeamApplyByProjectCreatorId(projectCreatorId);
        return ResultVOUtils.success(list);
    }

}
