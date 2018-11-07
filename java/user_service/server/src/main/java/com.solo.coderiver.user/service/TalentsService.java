package com.solo.coderiver.user.service;

import com.solo.coderiver.user.dto.TalentsListDTO;

import java.util.List;

public interface TalentsService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<TalentsListDTO> findAll(Integer page, Integer size, Integer sort);

    /**
     * 通过角色查询符合条件的用户
     *
     * @param role
     * @return
     */
    List<TalentsListDTO> findAllByRole(Integer page, Integer size, Integer role, Integer sort);

    /**
     * 通过经验查询符合条件的用户
     *
     * @param experience
     * @return
     */
    List<TalentsListDTO> findAllByExperience(Integer page, Integer size, Integer experience, Integer sort);

    /**
     * 通过经验和角色查询符合条件的用户
     *
     * @param role
     * @param experience
     * @return
     */
    List<TalentsListDTO> findAllByRoleAndExperience(Integer page, Integer size, Integer role, Integer experience, Integer sort);


}
