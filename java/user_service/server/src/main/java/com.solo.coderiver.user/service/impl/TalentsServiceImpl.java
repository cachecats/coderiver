package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.project.client.ProjectClient;
import com.solo.coderiver.project.common.ProjectInfoOutput;
import com.solo.coderiver.user.converter.UserInfoTalentsListDTOConverter;
import com.solo.coderiver.user.dataobject.UserInfo;
import com.solo.coderiver.user.dataobject.UserTeamRelation;
import com.solo.coderiver.user.dto.TalentsListDTO;
import com.solo.coderiver.user.dto.TeamInfoDTO;
import com.solo.coderiver.user.enums.ProjectStatusEnum;
import com.solo.coderiver.user.enums.TalentsSortEnum;
import com.solo.coderiver.user.service.TalentsService;
import com.solo.coderiver.user.service.TeamService;
import com.solo.coderiver.user.service.UserService;
import com.solo.coderiver.user.service.UserTeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TalentsServiceImpl implements TalentsService {

    @Autowired
    UserService userService;

    @Autowired
    UserTeamService userTeamService;

    @Autowired
    TeamService teamService;

    @Autowired
    ProjectClient projectClient;

    @Override
    public List<TalentsListDTO> findAll(Integer page, Integer size, Integer sort) {
        List<UserInfo> userInfos = userService.findAll(page, size, sort);
        return packageData(userInfos, sort);
    }

    @Override
    public List<TalentsListDTO> findAllByRole(Integer page, Integer size, Integer role, Integer sort) {
        List<UserInfo> userInfos = userService.findAllByRole(page, size, sort, role);
        return packageData(userInfos, sort);
    }

    @Override
    public List<TalentsListDTO> findAllByExperience(Integer page, Integer size, Integer experience, Integer sort) {
        List<UserInfo> userInfos = userService.findAllByExperience(page, size, sort, experience);
        return packageData(userInfos, sort);
    }

    @Override
    public List<TalentsListDTO> findAllByRoleAndExperience(Integer page, Integer size, Integer role, Integer experience, Integer sort) {
        List<UserInfo> userInfos = userService.findAllByRoleAndExperience(page, size, sort, role, experience);
        return packageData(userInfos, sort);
    }

    /**
     * 组装打包数据
     *
     * @param userInfos
     * @return
     */
    private List<TalentsListDTO> packageData(List<UserInfo> userInfos, Integer sort) {
        List<TalentsListDTO> talentsListDTOS = new ArrayList<>();
        for (UserInfo userInfo : userInfos) {
            TalentsListDTO dto = UserInfoTalentsListDTOConverter.userInfo2TalentsListDTO(userInfo);
            String userId = userInfo.getId();

            //查询并设置团队信息。通过用户团队关系表找到团队列表
            List<String> teamIds = userTeamService.findByUserId(userId)
                    .stream()
                    .map(UserTeamRelation::getTeamId)
                    .collect(Collectors.toList());
            List<TeamInfoDTO> teamInfoDTOS = teamService.findTeamsByTeamIds(teamIds)
                    .stream()
                    .map(info -> {
                        TeamInfoDTO teamInfoDTO = new TeamInfoDTO();
                        BeanUtils.copyProperties(info, teamInfoDTO);
                        return teamInfoDTO;
                    }).collect(Collectors.toList());
            dto.setTeams(teamInfoDTOS);

            //查询该用户参与的所有项目
            setProjectRecord(dto, userId);
            talentsListDTOS.add(dto);
        }
//        sortList(talentsListDTOS, sort);
        return talentsListDTOS;
    }

    /**
     * 对列表进行排序
     *
     * @param talentsListDTOS
     * @param sort
     */
    private List<TalentsListDTO> sortList(List<TalentsListDTO> talentsListDTOS, Integer sort) {
        //sort 为空则返回原列表
        if (sort == null) {
            return talentsListDTOS;
        }

        if (sort.equals(TalentsSortEnum.DEFAULT.getCode())) {
            //默认排序，返回原列表
            return talentsListDTOS;
        } else if (sort.equals(TalentsSortEnum.SORT_BY_EXPERIENCE.getCode())) {
            //根据经验排序.如果经验相同则比较影响力
            talentsListDTOS.sort(Comparator.comparing(TalentsListDTO::getExperience)
                    .thenComparing(TalentsListDTO::getInfluence)
                    .reversed());
        } else if (sort.equals(TalentsSortEnum.SORT_BY_INFLUENCE.getCode())) {
            //根据影响力排序.如果影响力相同则比较经验
            talentsListDTOS.sort(Comparator.comparing(TalentsListDTO::getInfluence)
                    .thenComparing(TalentsListDTO::getExperience)
                    .reversed());
        }
        return talentsListDTOS;
    }

    /**
     * 设置项目记录
     *
     * @param dto
     * @param userId
     */
    private void setProjectRecord(TalentsListDTO dto, String userId) {
        List<ProjectInfoOutput> projectInfoOutputs = projectClient.findProjectsByUserId(userId);
        Integer successNum = 0;
        Integer failNum = 0;
        Integer devNum = 0;
        for (ProjectInfoOutput output : projectInfoOutputs) {
            if (output.getProjectStatus().equals(ProjectStatusEnum.DEVELOPING.getCode())) {
                devNum++;
            } else if (output.getProjectStatus().equals(ProjectStatusEnum.SUCCESS.getCode())) {
                successNum++;
            } else {
                failNum++;
            }
        }
        dto.setRecordDeveloping(devNum);
        dto.setRecordSuccess(successNum);
        dto.setRecordFail(failNum);
    }


}
