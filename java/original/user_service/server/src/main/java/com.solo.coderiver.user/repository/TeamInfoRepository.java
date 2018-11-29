package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.dataobject.TeamInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamInfoRepository extends JpaRepository<TeamInfo, String> {

    TeamInfo findByTeamId(String teamId);

    List<TeamInfo> findByTeamIdIn(List<String> teamIds);

}
