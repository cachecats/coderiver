package com.solo.coderiver.project.mapper;

import com.solo.coderiver.project.dataobject.ProjectInfo;
import org.apache.ibatis.annotations.*;

/**
 * @Author: solo
 * @Date: 2018/12/7 3:16 PM
 * @Version 1.0
 * 注解方式使用 mybatis 增删改查
 */
@Mapper
public interface ProjectMapper {

    @Select("SELECT * FROM project_info WHERE project_id = #{id}")
    @Results({
            @Result(property = "projectId", column = "project_id"),
            @Result(property = "projectName", column = "project_name"),
            @Result(property = "projectAvatar", column = "project_avatar"),
            @Result(property = "projectDifficulty", column = "project_difficulty"),
            @Result(property = "categoryType", column = "category_type"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "projectProgress", column = "project_progress"),
            @Result(property = "projectStatus", column = "project_status"),
            @Result(property = "projectIntroduce", column = "project_introduce"),
            @Result(property = "projectCreatorId", column = "project_creator_id"),
            @Result(property = "teamId", column = "team_id"),
    })
    ProjectInfo findProjectById(String id);

    @Insert("INSERT INTO " +
            "project_info(project_id, project_name, project_avatar, project_difficulty," +
            " category_type, category_name, project_progress, project_status, " +
            "project_introduce, project_creator_id, team_id) " +
            "VALUES(#{projectId}, #{projectName}, #{projectAvatar}, #{projectDifficulty}," +
            "#{categoryType}, #{categoryName}, #{projectProgress}, #{projectStatus}," +
            "#{projectIntroduce}, #{projectCreatorId}, #{teamId})")
    int insertProject(ProjectInfo info);


    @Update("UPDATE project_info set project_name = #{name} where project_id = #{id}")
    int updateProjectName(String id, String name);

    @Delete("DELETE FROM project_info WHERE project_id = #{id}")
    int deleteProject(String id);


}
