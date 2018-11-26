package com.solo.coderiver.user.converter;

import com.solo.coderiver.user.dataobject.WorkExperience;
import com.solo.coderiver.user.dto.WorkExperienceDTO;
import com.solo.coderiver.user.utils.DateUtils;
import org.springframework.beans.BeanUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class WorkExperienceConverter {

    public static WorkExperienceDTO entity2dto(WorkExperience entity) {
        WorkExperienceDTO dto = new WorkExperienceDTO();
        BeanUtils.copyProperties(entity, dto);
        try {
            dto.setStartDate(DateUtils.dateFormat(entity.getStartDate()));
            dto.setEndDate(DateUtils.dateFormat(entity.getEndDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public static WorkExperience dto2entity(WorkExperienceDTO dto) {
        WorkExperience entity = new WorkExperience();
        BeanUtils.copyProperties(dto, entity);
        try {
            entity.setStartDate(DateUtils.dateParse(dto.getStartDate()));
            entity.setEndDate(DateUtils.dateParse(dto.getEndDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static List<WorkExperienceDTO> entities2dtos(List<WorkExperience> entities) {
        List<WorkExperienceDTO> dtos = new ArrayList<>();
        for (WorkExperience entity : entities) {
            dtos.add(entity2dto(entity));
        }
        return dtos;
    }
}
