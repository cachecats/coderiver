package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.dataobject.UserTeamRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTeamRepository extends JpaRepository<UserTeamRelation, Integer> {

    /**
     * 通过用户id查询对应关系
     *
     * @param userId
     * @return
     */
    List<UserTeamRelation> findByUserId(String userId);

    /**
     * 通过团队id查询对应关系
     *
     * @param teamId
     * @return
     */
    List<UserTeamRelation> findByTeamId(String teamId);


}
