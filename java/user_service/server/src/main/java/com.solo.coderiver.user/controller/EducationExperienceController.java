package com.solo.coderiver.user.controller;

import com.solo.coderiver.user.VO.ResultVO;
import com.solo.coderiver.user.converter.EducationExperienceConverter;
import com.solo.coderiver.user.dataobject.EducationExperience;
import com.solo.coderiver.user.dto.EducationExperienceDTO;
import com.solo.coderiver.user.enums.ResultEnum;
import com.solo.coderiver.user.exception.UserException;
import com.solo.coderiver.user.service.EducationService;
import com.solo.coderiver.user.utils.ResultVOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(description = "个人信息的教育经历相关接口")
@RequestMapping("/edu")
@Slf4j
public class EducationExperienceController {

    @Autowired
    EducationService educationService;

    @PostMapping("/save")
    @ApiOperation("保存教育经历")
    public ResultVO save(@Valid EducationExperienceDTO dto, BindingResult bindingResult) {
        //校验不通过
        if (bindingResult.hasErrors()) {
            log.error("【保存教育经历】参数错误，dto=${}", dto.toString());
            throw new UserException(ResultEnum.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        EducationExperience experience = EducationExperienceConverter.dto2entity(dto);
        educationService.save(experience);
        return ResultVOUtils.success();
    }

    @GetMapping("/find/{id}")
    @ApiOperation("通过用户id查询教育经历")
    @ApiImplicitParam(name = "id", value = "用户id")
    public ResultVO findByUserId(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            throw new UserException(ResultEnum.USER_ID_CANNOT_EMPTY);
        }
        List<EducationExperience> list = educationService.findByUserId(id);
        List<EducationExperienceDTO> dtos = EducationExperienceConverter.entities2dtos(list);

        return ResultVOUtils.success(dtos);
    }

    @PostMapping("/update")
    @ApiOperation("更新教育经历")
    public ResultVO update(@Valid EducationExperienceDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【更新教育经历】参数错误，dto=${}", dto.toString());
            throw new UserException(ResultEnum.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        if (dto.getId() == null || StringUtils.isEmpty(String.valueOf(dto.getId()))) {
            throw new UserException(ResultEnum.MAIN_ID_NOT_NULL);
        }
        EducationExperience experience = EducationExperienceConverter.dto2entity(dto);
        educationService.save(experience);
        return ResultVOUtils.success();
    }
}
