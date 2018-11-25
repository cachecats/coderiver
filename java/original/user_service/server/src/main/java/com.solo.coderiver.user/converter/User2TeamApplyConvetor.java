package com.solo.coderiver.user.converter;

import com.solo.coderiver.user.dataobject.TeamApply;
import com.solo.coderiver.user.dataobject.UserInfo;
import org.springframework.beans.BeanUtils;

/**
 * UserInfo 与 TeamApply 互转的工具类
 */
public class User2TeamApplyConvetor {

    public static TeamApply user2TeamApply(UserInfo user) {
        TeamApply teamApply = new TeamApply();
        //四个时间可以直接拷贝，其他的需要赋值
        BeanUtils.copyProperties(user, teamApply);
        teamApply.setApplicantsId(user.getId());
        teamApply.setApplicantsName(user.getName());
        teamApply.setApplicantsAvatar(user.getAvatar());
        teamApply.setApplicantsCity(user.getCity());
        teamApply.setApplicantsExperience(user.getExperience());
        return teamApply;
    }
}
