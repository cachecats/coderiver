package com.solo.coderiver.user.converter;

import com.solo.coderiver.user.dataobject.UserInfo;
import com.solo.coderiver.user.dto.TalentsListDTO;
import com.solo.coderiver.user.utils.DateUtils;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * UserInfo 与 TalentsListDTO 对象的转换类
 */
public class UserInfoTalentsListDTOConverter {

    public static TalentsListDTO userInfo2TalentsListDTO(UserInfo userInfo) {
        TalentsListDTO dto = new TalentsListDTO();
        BeanUtils.copyProperties(userInfo, dto);
        dto.setWorkdayStartTime(DateUtils.timeFormat(userInfo.getWorkdayStartTime()));
        dto.setWorkdayEndTime(DateUtils.timeFormat(userInfo.getWorkdayEndTime()));
        dto.setWeekendStartTime(DateUtils.timeFormat(userInfo.getWeekendStartTime()));
        dto.setWeekendEndTime(DateUtils.timeFormat(userInfo.getWeekendEndTime()));
        return dto;
    }

    public static List<TalentsListDTO> userInfos2TalentsListDTOS(List<UserInfo> userInfos) {
        List<TalentsListDTO> dtos = new ArrayList<>();
        for (UserInfo info : userInfos) {
            dtos.add(userInfo2TalentsListDTO(info));
        }
        return dtos;
    }
}
