package com.solo.coderiver.user.service;

import com.solo.coderiver.user.dataobject.UserTeamRelation;

import java.util.List;

public interface UserTeamService {

    UserTeamRelation save(UserTeamRelation relation);

    List<UserTeamRelation> findByUserId(String userId);

    List<UserTeamRelation> findByTeamId(String teamId);
}
