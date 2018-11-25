package com.solo.coderiver.user.service;

import com.solo.coderiver.user.dataobject.TeamApply;
import com.solo.coderiver.user.dataobject.TeamInfo;

import java.util.List;

public interface TeamService {

    /**
     * 保存团队信息
     *
     * @param teamInfo
     * @return
     */
    TeamInfo save(TeamInfo teamInfo);

    /**
     * 通过 teamid 查询团队信息
     *
     * @param teamId
     * @return
     */
    TeamInfo findByTeamId(String teamId);

    /**
     * 通过 teamid 集合查询多个团队信息
     *
     * @param teamIds
     * @return
     */
    List<TeamInfo> findTeamsByTeamIds(List<String> teamIds);

    /**
     * 保存组队申请
     *
     * @param teamApply
     * @return
     */
    TeamApply saveTeamApply(TeamApply teamApply);

    /**
     * 通过项目创建者查询组队申请
     *
     * @param projectCreatorId
     * @return
     */
    List<TeamApply> findTeamApplyByProjectCreatorId(String projectCreatorId);

    /**
     * 通过申请者id查询组队申请
     *
     * @param applicantsId
     * @return
     */
    List<TeamApply> findTeamApplyByApplicantsId(String applicantsId);
}
