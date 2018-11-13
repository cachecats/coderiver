package com.solo.coderiver.user.converter;

import com.solo.coderiver.user.dataobject.EducationExperience;
import com.solo.coderiver.user.dto.EducationExperienceDTO;
import com.solo.coderiver.user.utils.DateUtils;
import org.springframework.beans.BeanUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * EducationExperience 的实体类与 dto 的转化类
 */
public class EducationExperienceConverter {

    public static EducationExperience dto2entity(EducationExperienceDTO dto) {
        EducationExperience entity = new EducationExperience();
        BeanUtils.copyProperties(dto, entity);
        try {
            entity.setStartDate(DateUtils.dateParse(dto.getStartDate()));
            entity.setEndDate(DateUtils.dateParse(dto.getEndDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static EducationExperienceDTO entity2dto(EducationExperience entity) {
        EducationExperienceDTO dto = new EducationExperienceDTO();
        BeanUtils.copyProperties(entity, dto);
        try {
            dto.setStartDate(DateUtils.dateFormat(entity.getStartDate()));
            dto.setEndDate(DateUtils.dateFormat(entity.getEndDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public static List<EducationExperienceDTO> entities2dtos(List<EducationExperience> entities) {
        List<EducationExperienceDTO> list = new ArrayList<>();
        for (EducationExperience entity : entities) {
            list.add(entity2dto(entity));
        }
        return list;
    }
}
