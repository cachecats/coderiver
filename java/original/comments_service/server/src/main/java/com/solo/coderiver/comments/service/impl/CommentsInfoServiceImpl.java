package com.solo.coderiver.comments.service.impl;

import com.solo.coderiver.comments.converter.CommentsConverter;
import com.solo.coderiver.comments.dataobject.CommentsInfo;
import com.solo.coderiver.comments.dto.CommentsInfoDTO;
import com.solo.coderiver.comments.repository.CommentsInfoRepository;
import com.solo.coderiver.comments.service.CommentsInfoService;
import com.solo.coderiver.user.client.UserClient;
import com.solo.coderiver.user.common.UserInfoForComments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentsInfoServiceImpl implements CommentsInfoService {

    @Autowired
    CommentsInfoRepository repository;

    @Autowired
    UserClient userClient;

    @Override
    @CacheEvict(cacheNames = "comments", key = "#dto.ownerId")
    public CommentsInfoDTO save(CommentsInfoDTO dto) {
        CommentsInfo result = repository.save(CommentsConverter.DTO2Info(dto));
        return CommentsConverter.info2DTO(result);
    }

    @Override
    @Cacheable(cacheNames = "comments", key = "#ownerId")
    public List<CommentsInfoDTO> findByOwnerId(String ownerId) {
        log.info("取了数据库----------");
        List<CommentsInfo> infoList = repository.findByOwnerId(ownerId);
        List<CommentsInfoDTO> list = CommentsConverter.infos2DTOList(infoList)
                .stream()
                .map(dto -> {
                    //从用户服务取评论者头像
                    UserInfoForComments fromUser = userClient.getAvatarByUserId(dto.getFromId());
                    if (fromUser != null) {
                        dto.setFromAvatar(fromUser.getAvatar());
                    }

                    //从用户服务取被评论者头像
                    String toId = dto.getToId();
                    if (!StringUtils.isEmpty(toId)) {
                        UserInfoForComments toUser = userClient.getAvatarByUserId(toId);
                        if (toUser != null) {
                            dto.setToAvatar(toUser.getAvatar());
                        }
                    }
                    return dto;
                }).collect(Collectors.toList());
        return sortData(list);
    }

    /**
     * 将无序的数据整理成有层级关系的数据
     *
     * @param dtos
     * @return
     */
    private List<CommentsInfoDTO> sortData(List<CommentsInfoDTO> dtos) {
        List<CommentsInfoDTO> list = new ArrayList<>();
        for (int i = 0; i < dtos.size(); i++) {
            CommentsInfoDTO dto1 = dtos.get(i);
            List<CommentsInfoDTO> children = new ArrayList<>();
            for (int j = 0; j < dtos.size(); j++) {
                CommentsInfoDTO dto2 = dtos.get(j);
                if (dto2.getPid() == null) {
                    continue;
                }
                if (dto1.getId().equals(dto2.getPid())) {
                    children.add(dto2);
                }
            }
            dto1.setChildren(children);
            //最外层的数据只添加 pid 为空的评论，其他评论在父评论的 children 下
            if (dto1.getPid() == null || StringUtils.isEmpty(dto1.getPid())) {
                list.add(dto1);
            }
        }
        return list;
    }
}
