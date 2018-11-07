package com.solo.coderiver.user.controller;

import com.solo.coderiver.user.VO.ResultVO;
import com.solo.coderiver.user.dto.TalentsListDTO;
import com.solo.coderiver.user.service.TalentsService;
import com.solo.coderiver.user.utils.ResultVOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/talents")
@Api(description = "人才广场相关接口")
public class TalentsController {

    @Autowired
    TalentsService talentsService;

    @GetMapping("/all")
    @ApiOperation("查询人才列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "角色", required = false),
            @ApiImplicitParam(name = "experience", value = "经验", required = false),
            @ApiImplicitParam(name = "sort", value = "排序", required = false),
            @ApiImplicitParam(name = "page", value = "当前页", required = true),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true),
    })
    public ResultVO findList(@RequestParam(value = "role", required = false) Integer role,
                             @RequestParam(value = "experience", required = false) Integer experience,
                             @RequestParam(value = "sort", required = false) Integer sort,
                             @RequestParam(value = "page", required = true) Integer page,
                             @RequestParam(value = "size", required = true) Integer size) {
        //role 和 experience 都为空则没有筛选条件查询所有
        if (role == null && experience == null) {
            List<TalentsListDTO> all = talentsService.findAll(page, size, sort);
            return ResultVOUtils.success(all);
        } else if (role == null) {
            //按经验筛选
            List<TalentsListDTO> dtos = talentsService.findAllByExperience(page, size, experience, sort);
            return ResultVOUtils.success(dtos);
        } else if (experience == null) {
            //按角色筛选
            List<TalentsListDTO> dtos = talentsService.findAllByRole(page, size, role, sort);
            return ResultVOUtils.success(dtos);
        } else {
            //按角色和经验双重筛选
            List<TalentsListDTO> dtos = talentsService.findAllByRoleAndExperience(page, size, role, experience, sort);
            return ResultVOUtils.success(dtos);
        }
    }


}
