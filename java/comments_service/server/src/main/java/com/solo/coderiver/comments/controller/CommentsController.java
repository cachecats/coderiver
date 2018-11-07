package com.solo.coderiver.comments.controller;

import com.solo.coderiver.comments.VO.ResultVO;
import com.solo.coderiver.comments.dataobject.CommentsInfo;
import com.solo.coderiver.comments.dataobject.CommentsReply;
import com.solo.coderiver.comments.dto.CommentsInfoDTO;
import com.solo.coderiver.comments.dto.CommentsReplyDTO;
import com.solo.coderiver.comments.enums.ResultEnums;
import com.solo.coderiver.comments.exception.CommentsException;
import com.solo.coderiver.comments.form.CommentsInfoForm;
import com.solo.coderiver.comments.form.CommentsReplyForm;
import com.solo.coderiver.comments.service.CommentsInfoService;
import com.solo.coderiver.comments.service.CommentsReplyService;
import com.solo.coderiver.comments.utils.KeyUtils;
import com.solo.coderiver.comments.utils.ResultVOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(description = "评论相关接口")
public class CommentsController {

    @Autowired
    CommentsInfoService infoService;

    @Autowired
    CommentsReplyService replyService;

    @PostMapping("/save")
    @ApiOperation("保存评论")
    @Transactional
    public ResultVO saveComments(@Valid CommentsInfoForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CommentsException(ResultEnums.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        //将 CommentsInfoForm 里的数据拷贝到 CommentsInfo
        CommentsInfo info = new CommentsInfo();
        BeanUtils.copyProperties(form, info);
        // 生成并设置评论的主键id
        info.setId(KeyUtils.genUniqueKey());
        CommentsInfo result = infoService.save(info);
        if (result == null) {
            throw new CommentsException(ResultEnums.SAVE_COMMENTS_FAIL);
        }
        return ResultVOUtils.success();
    }

    @GetMapping("/get/{ownerId}")
    @ApiOperation("根据 ownerId 查询评论")
    @ApiImplicitParam(name = "ownerId", value = "被评论者id")
    public ResultVO getCommentsByOwnerId(@PathVariable("ownerId") String ownerId) {
        List<CommentsInfo> infoList = infoService.findByOwnerId(ownerId);
        //将 CommentsInfo 转换为 CommentsInfoDTO
        List<CommentsInfoDTO> infoDTOS = infoList.stream().map(info -> {
            CommentsInfoDTO dto = new CommentsInfoDTO();
            BeanUtils.copyProperties(info, dto);
            return dto;
        }).collect(Collectors.toList());
        return ResultVOUtils.success(infoDTOS);
    }

    @PostMapping("/save-reply")
    @ApiOperation("保存评论回复")
    @Transactional
    public ResultVO saveReply(@Valid CommentsReplyForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CommentsException(ResultEnums.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        CommentsReply reply = new CommentsReply();
        BeanUtils.copyProperties(form, reply);
        CommentsReply result = replyService.save(reply);
        if (result == null) {
            throw new CommentsException(ResultEnums.SAVE_COMMENTS_FAIL);
        }
        return ResultVOUtils.success();
    }

    @GetMapping("/get-reply/{commentId}")
    @ApiOperation("通过commentId获取评论回复")
    public ResultVO getReplyByCommentId(@PathVariable("commentId") String commentId) {
        List<CommentsReply> replyList = replyService.findByCommentId(commentId);
        //将 CommentsReply 转换为 CommentsReplyDTO
        List<CommentsReplyDTO> replyDTOS = replyList.stream().map(reply -> {
            CommentsReplyDTO dto = new CommentsReplyDTO();
            BeanUtils.copyProperties(reply, dto);
            return dto;
        }).collect(Collectors.toList());

        return ResultVOUtils.success(replyDTOS);
    }

}
