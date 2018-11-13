package com.solo.coderiver.user.controller;

import com.solo.coderiver.user.VO.ResultVO;
import com.solo.coderiver.user.converter.WorkExperienceConverter;
import com.solo.coderiver.user.dataobject.WorkExperience;
import com.solo.coderiver.user.dto.WorkExperienceDTO;
import com.solo.coderiver.user.enums.ResultEnum;
import com.solo.coderiver.user.exception.UserException;
import com.solo.coderiver.user.service.WorkService;
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
@Api(description = "工作经历controller")
@RequestMapping("/work")
@Slf4j
public class WorkExperienceController {

    @Autowired
    WorkService workService;

    @PostMapping("/save")
    @ApiOperation("新增工作经历")
    public ResultVO save(@Valid WorkExperienceDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【新增工作经历】参数错误，dto={}", dto.toString());
            throw new UserException(ResultEnum.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        WorkExperience entity = WorkExperienceConverter.dto2entity(dto);
        workService.save(entity);
        return ResultVOUtils.success();
    }

    @GetMapping("/find/{id}")
    @ApiOperation("通过用户id查询工作经历，返回工作经历数组")
    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    public ResultVO findByUserId(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            throw new UserException(ResultEnum.USER_ID_CANNOT_EMPTY);
        }
        List<WorkExperience> list = workService.findByUserId(id);
        List<WorkExperienceDTO> dtos = WorkExperienceConverter.entities2dtos(list);
        return ResultVOUtils.success(dtos);
    }

    @PostMapping("/update")
    @ApiOperation("修改工作经历")
    public ResultVO update(@Valid WorkExperienceDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【新增工作经历】参数错误，dto={}", dto.toString());
            throw new UserException(ResultEnum.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        if (dto.getId() == null || StringUtils.isEmpty(String.valueOf(dto.getId()))) {
            throw new UserException(ResultEnum.MAIN_ID_NOT_NULL);
        }
        WorkExperience entity = WorkExperienceConverter.dto2entity(dto);
        workService.save(entity);
        return ResultVOUtils.success();
    }
}
