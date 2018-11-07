package com.solo.coderiver.comments.service.impl;

import com.solo.coderiver.comments.dataobject.CommentsInfo;
import com.solo.coderiver.comments.repository.CommentsInfoRepository;
import com.solo.coderiver.comments.service.CommentsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsInfoServiceImpl implements CommentsInfoService {

    @Autowired
    CommentsInfoRepository repository;

    @Override
    public CommentsInfo save(CommentsInfo info) {
        return repository.save(info);
    }

    @Override
    public List<CommentsInfo> findByOwnerId(String ownerId) {
        return repository.findByOwnerId(ownerId);
    }
}
