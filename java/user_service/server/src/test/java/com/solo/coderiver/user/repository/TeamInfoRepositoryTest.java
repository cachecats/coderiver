package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dataobject.TeamInfo;
import com.solo.coderiver.user.utils.KeyUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TeamInfoRepositoryTest extends UserApplicationTest {

    @Autowired
    TeamInfoRepository repository;

    @Test
    public void save() {
        TeamInfo team = new TeamInfo();
        team.setTeamId(KeyUtils.genUniqueKey());
        team.setTeamAvatar("http://xxxx.png");
        team.setTeamName("Java学习小组");
        team.setTeamIntroduce("Java是世界上最好的语言");
        team.setTeamCreatorId("333333");
        TeamInfo result = repository.save(team);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByTeamId() {
        TeamInfo team = repository.findByTeamId("1539241759133234444");
        Assert.assertNotNull(team);
    }
}