package com.solo.coderiver.project.service.impl;

import com.solo.coderiver.project.VO.MemberVO;
import com.solo.coderiver.project.VO.ProjectDetailVO;
import com.solo.coderiver.project.VO.ProjectInfoVO;
import com.solo.coderiver.project.common.ProjectInfoOutput;
import com.solo.coderiver.project.dataobject.*;
import com.solo.coderiver.project.dto.ProjectInfoDTO;
import com.solo.coderiver.project.dto.ProjectMemberDTO;
import com.solo.coderiver.project.dto.ProjectPictureDTO;
import com.solo.coderiver.project.enums.ProjectMemberStatusEnum;
import com.solo.coderiver.project.enums.ProjectSortEnum;
import com.solo.coderiver.project.enums.ResultEnums;
import com.solo.coderiver.project.enums.RoleEnum;
import com.solo.coderiver.project.exception.ProjectException;
import com.solo.coderiver.project.form.NewProjectForm;
import com.solo.coderiver.project.form.ProjectMemberForm;
import com.solo.coderiver.project.repository.*;
import com.solo.coderiver.project.service.ProjectMemberService;
import com.solo.coderiver.project.service.ProjectPictureService;
import com.solo.coderiver.project.service.ProjectService;
import com.solo.coderiver.project.utils.KeyUtils;
import com.solo.coderiver.project.utils.RoleUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectInfoRepository projectInfoRepository;

    @Autowired
    ProjectCategoryRepository categoryRepository;

    @Autowired
    ProjectPictureService pictureService;

    @Autowired
    UserProjectRepository userProjectRepository;

    @Autowired
    ProjectMemberService memberService;

    @Override
    public ProjectInfo findProjectByProjectId(String projectId) {
        return projectInfoRepository.findByProjectId(projectId);
    }

    @Override
    @Transactional
    public void saveProject(NewProjectForm form) {
        String projectId = KeyUtils.genUniqueKey();
        ProjectInfo info = new ProjectInfo();
        info.setProjectId(projectId);
        info.setProjectCreatorId(form.getUserId());
        BeanUtils.copyProperties(form, info);
        //保存 ProjectInfo
        ProjectInfo save = projectInfoRepository.save(info);
        if (save == null) {
            throw new ProjectException(ResultEnums.NEW_PROJECT_FAIL);
        }

        //保存团队成员信息。团队成员信息不能为空
        List<ProjectMemberForm> members = form.getMembers();
        //存储在数据库中的成员信息
        List<ProjectMember> memberList = new ArrayList<>();
        for (ProjectMemberForm member : members) {
            for (int i = 0; i < member.getCount(); i++) {
                String roleName = RoleUtils.getRoleNameByRoleCode(member.getUserRole());
                ProjectMember pm = new ProjectMember(projectId, info.getProjectName(),
                        info.getProjectAvatar(), member.getUserRole(), roleName, ProjectMemberStatusEnum.UNMATCH.getCode()
                );
                memberList.add(pm);
            }
        }
        //根据项目创建者选择的角色，占用一个该角色的名额
        Integer ownerRole = form.getOwnerRole();
        for (ProjectMember mem : memberList) {
            if (mem.getUserRole().equals(ownerRole)) {
                mem.setStatus(1);
                break;
            }
        }
        List<ProjectMember> memberResults = memberService.saveAll(memberList);
        if (memberList.size() == 0) {
            throw new ProjectException(ResultEnums.NEW_PROJECT_FAIL);
        }

        //保存项目截图
        String pictures = form.getProjectPictures();
        //截图可以为空
        if (!StringUtils.isEmpty(pictures)) {
            String[] pictureUrls = pictures.split(",");
            List<ProjectPicture> pictureList = new ArrayList<>();
            for (int i = 0; i < pictureUrls.length; i++) {
                ProjectPicture picture = new ProjectPicture(projectId, pictureUrls[i]);
                pictureList.add(picture);
            }

            log.info("pictureList:{}", pictureList);

            List<ProjectPicture> pictureResults = pictureService.saveAll(pictureList);
            if (pictureResults.size() == 0) {
                throw new ProjectException(ResultEnums.NEW_PROJECT_FAIL);
            }
        }
    }

    @Override
    @Transactional
    public ProjectCategory saveProjectCategory(ProjectCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public ProjectCategory findCategoryByCategoryType(Integer type) {
        return categoryRepository.findByCategoryType(type);
    }


    @Override
    public List<UserProjectRelation> findRelationByProjectId(String projectId) {
        return userProjectRepository.findByProjectId(projectId);
    }

    @Override
    public List<ProjectInfoOutput> findProjectsByUserId(String userId) {
        List<String> projectIds = userProjectRepository.findByUserId(userId)
                .stream()
                .map(UserProjectRelation::getProjectId)
                .collect(Collectors.toList());
        List<ProjectInfoOutput> infoOutputList = projectInfoRepository.findByProjectIdIn(projectIds)
                .stream()
                .map(info -> {
                    ProjectInfoOutput output = new ProjectInfoOutput();
                    BeanUtils.copyProperties(info, output);
                    return output;
                }).collect(Collectors.toList());

        return infoOutputList;
    }

    @Override
    public List<ProjectInfoVO> getProjectList(Integer page, Integer size, Integer sort) {
        Page<ProjectInfo> pages = projectInfoRepository.findAll(genSortedPageable(page, size, sort));
        List<ProjectInfo> projectList = pages.getContent();
        return packageProductInfoVO(projectList, sort);
    }

    @Override
    public List<ProjectInfoVO> getProjectListByCategoryType(Integer page, Integer size, Integer type, Integer sort) {
        Page<ProjectInfo> pages = projectInfoRepository.findByCategoryType(genSortedPageable(page, size, sort), type);
        List<ProjectInfo> list = pages.getContent();
        return packageProductInfoVO(list, sort);
    }

    @Override
    public List<ProjectInfoVO> getProjectListByProjectProgress(Integer page, Integer size, Integer progress, Integer sort) {
        Page<ProjectInfo> pages = projectInfoRepository.findByProjectProgress(genSortedPageable(page, size, sort), progress);
        List<ProjectInfo> list = pages.getContent();
        return packageProductInfoVO(list, sort);
    }

    @Override
    public List<ProjectInfoVO> getProjectListByTypeAndProgress(Integer page, Integer size, Integer type, Integer progress, Integer sort) {
        Page<ProjectInfo> pages = projectInfoRepository.findByCategoryTypeAndProjectProgress(
                genSortedPageable(page, size, sort), type, progress);
        List<ProjectInfo> list = pages.getContent();
        return packageProductInfoVO(list, sort);
    }

    @Override
    public ProjectDetailVO getProjectDetail(String projectId) {
        //查询项目信息 ProjectInfo
        ProjectInfo projectInfo = findProjectByProjectId(projectId);
        //将 ProjectInfo 拷贝到 ProjectInfoDTO
        ProjectInfoDTO projectInfoDTO = new ProjectInfoDTO();
        BeanUtils.copyProperties(projectInfo, projectInfoDTO);

        // 查询团队成员 ProjectMember 并转化为 ProjectMemberDTO
        List<ProjectMember> members = memberService.findMembersByProjectId(projectId);
        List<ProjectMemberDTO> memberDTOS = members.stream().filter(member -> member.getStatus().equals(ProjectMemberStatusEnum.MATCH.getCode()))
                .map(mem -> new ProjectMemberDTO(mem.getUserId(), mem.getUserName(), mem.getUserAvatar(),
                        mem.getUserRole(), mem.getRoleName()))
                .collect(Collectors.toList());

        //查询项目截图并转换为 ProjectPictureDTO
        List<ProjectPicture> pictures = pictureService.findByProjectId(projectId);
        List<ProjectPictureDTO> pictureDTOS = pictures.stream().map(picture -> {
            ProjectPictureDTO dto = new ProjectPictureDTO();
            BeanUtils.copyProperties(picture, dto);
            return dto;
        }).collect(Collectors.toList());

        //组装数据
        ProjectDetailVO detailVO = new ProjectDetailVO();
        detailVO.setProjectInfoDTO(projectInfoDTO);
        detailVO.setMembers(memberDTOS);
        detailVO.setPictures(pictureDTOS);

        return detailVO;
    }

    private List<ProjectInfoVO> packageProductInfoVO(List<ProjectInfo> projectList, Integer sort) {
        List<ProjectInfoVO> voList = new ArrayList<>();
        for (ProjectInfo info : projectList) {
            //将 ProjectInfo 的属性拷贝到 ProjectInfoVO 中
            ProjectInfoVO infoVO = new ProjectInfoVO();
            BeanUtils.copyProperties(info, infoVO);
            //组织成员信息
            List<MemberVO> memberVOS = new ArrayList<>();
            List<ProjectMember> members = memberService.findMembersByProjectId(info.getProjectId());
            RoleEnum[] roles = RoleEnum.values();

            for (RoleEnum role : roles) {
                int total = 0;
                int actual = 0;
                MemberVO memberVO = new MemberVO();
                for (ProjectMember member : members) {
                    if (member.getUserRole().equals(role.getCode())) {
                        total++;
                        if (member.getStatus().equals(ProjectMemberStatusEnum.MATCH.getCode())) {
                            actual++;
                        }
                    }
                    log.info(member.toString());
                    memberVO.setRoleName(role.getMsg());
                    memberVO.setNeedNum(total);
                    memberVO.setActualNum(actual);
                }
                if (total != 0) {
                    memberVOS.add(memberVO);
                }
            }
            infoVO.setMemberList(memberVOS);
            voList.add(infoVO);
        }
        //排序
//        sortList(voList, sort);
        return voList;
    }

    //排序
    private void sortList(List<ProjectInfoVO> list, Integer sort) {
        if (sort == null || sort.equals(ProjectSortEnum.DEFAULT.getCode())) {
            //不传排序或默认排序，直接返回
            return;
        } else if (sort.equals(ProjectSortEnum.DIFFICULTY_LOW_TO_HIGH.getCode())) {
            //难度从低到高排序
            list.sort(Comparator.comparing(ProjectInfoVO::getProjectDifficulty));
        } else if (sort.equals(ProjectSortEnum.DIFFICULTY_HIGH_TO_LOW.getCode())) {
            //难度从高到低排序
            list.sort(Comparator.comparing(ProjectInfoVO::getProjectDifficulty).reversed());
        }
    }

    /**
     * 根据条件生成带排序的 Pageable 对象
     *
     * @param page
     * @param size
     * @param sort
     * @return
     */
    private PageRequest genSortedPageable(Integer page, Integer size, Integer sort) {
        if (sort == null || sort.equals(ProjectSortEnum.DEFAULT.getCode())) {
            //不传排序或默认排序，直接返回
            return PageRequest.of(page, size);
        } else if (sort.equals(ProjectSortEnum.DIFFICULTY_LOW_TO_HIGH.getCode())) {
            //难度从低到高排序
            return PageRequest.of(page, size, Sort.Direction.ASC, "projectDifficulty");
        } else if (sort.equals(ProjectSortEnum.DIFFICULTY_HIGH_TO_LOW.getCode())) {
            //难度从高到低排序
            return PageRequest.of(page, size, Sort.Direction.DESC, "projectDifficulty");
        }
        return PageRequest.of(page, size);
    }


}
