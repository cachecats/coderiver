package com.solo.coderiver.comments.converter;

import com.solo.coderiver.comments.dataobject.CommentsInfo;
import com.solo.coderiver.comments.dto.CommentsInfoDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CommentsInfo 与 CommentsInfoDTO 相互转换的工具类
 */
public class CommentsConverter {

    public static CommentsInfoDTO info2DTO(CommentsInfo info){
        CommentsInfoDTO dto = new CommentsInfoDTO();
        BeanUtils.copyProperties(info, dto);
        return dto;
    }

    public static CommentsInfo DTO2Info(CommentsInfoDTO dto){
        CommentsInfo info = new CommentsInfo();
        BeanUtils.copyProperties(dto, info);
        return info;
    }

    public static List<CommentsInfoDTO> infos2DTOList(List<CommentsInfo> infos){
        return infos.stream().map(info -> info2DTO(info)).collect(Collectors.toList());
    }
}
