package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.dataobject.TeamApply;
import com.solo.coderiver.user.dataobject.TeamInfo;
import com.solo.coderiver.user.repository.TeamApplyRepository;
import com.solo.coderiver.user.repository.TeamInfoRepository;
import com.solo.coderiver.user.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamInfoRepository repository;

    @Autowired
    TeamApplyRepository teamApplyRepository;

    @Override
    @Transactional
    public TeamInfo save(TeamInfo teamInfo) {
        return repository.save(teamInfo);
    }

    @Override
    public TeamInfo findByTeamId(String teamId) {
        return repository.findByTeamId(teamId);
    }

    @Override
    public List<TeamInfo> findTeamsByTeamIds(List<String> teamIds) {
        return repository.findByTeamIdIn(teamIds);
    }

    @Override
    @Transactional
    public TeamApply saveTeamApply(TeamApply teamApply) {
        return teamApplyRepository.save(teamApply);
    }

    @Override
    public List<TeamApply> findTeamApplyByProjectCreatorId(String projectCreatorId) {
        return teamApplyRepository.findByProjectCreatorId(projectCreatorId);
    }

    @Override
    public List<TeamApply> findTeamApplyByApplicantsId(String applicantsId) {
        return teamApplyRepository.findByApplicantsId(applicantsId);
    }
}
