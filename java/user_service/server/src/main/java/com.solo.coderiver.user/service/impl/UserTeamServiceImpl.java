package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.dataobject.UserTeamRelation;
import com.solo.coderiver.user.repository.UserTeamRepository;
import com.solo.coderiver.user.service.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserTeamServiceImpl implements UserTeamService {

    @Autowired
    UserTeamRepository repository;

    @Override
    @Transactional
    public UserTeamRelation save(UserTeamRelation relation) {
        return repository.save(relation);
    }

    @Override
    public List<UserTeamRelation> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<UserTeamRelation> findByTeamId(String teamId) {
        return repository.findByTeamId(teamId);
    }
}
