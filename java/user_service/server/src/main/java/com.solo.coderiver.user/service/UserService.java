package com.solo.coderiver.user.service;

import com.solo.coderiver.user.dataobject.UserInfo;
import com.solo.coderiver.user.dto.ExperienceDTO;
import com.solo.coderiver.user.dto.RoleDTO;
import com.solo.coderiver.user.dto.UserInfoDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    /**
     * 注册
     *
     * @param userInfo
     * @return
     */
    UserInfoDTO registerByEmail(UserInfoDTO userInfo);

    /**
     * 更新个人信息
     *
     * @param userInfo
     * @return
     */
    UserInfo updateInfo(UserInfo userInfo);

    /**
     * 用邮箱登录
     *
     * @param email
     * @param password
     * @return
     */
    UserInfoDTO loginByEmail(String email, String password);

    /**
     * 用电话登录
     *
     * @param tel
     * @param password
     * @return
     */
    UserInfo loginByTel(String tel, String password);

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    UserInfo findById(String id);

    /**
     * 重置/修改 密码
     *
     * @return
     */
    UserInfo resetPassword(String id, String oldPassword, String newPassword);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<UserInfo> findAll(Integer page, Integer size, Integer sort);

    /**
     * 通过角色筛选该角色下的所有用户
     *
     * @param role 用户角色
     * @return
     */
    List<UserInfo> findAllByRole(Integer page, Integer size, Integer sort, Integer role);

    /**
     * 通过经验筛选符合条件的用户
     *
     * @param experience 用户经验
     * @return
     */
    List<UserInfo> findAllByExperience(Integer page, Integer size, Integer sort, Integer experience);

    /**
     * 通过角色和经验双重筛选符合条件的用户
     *
     * @param role       用户角色
     * @param experience 用户经验
     * @return
     */
    List<UserInfo> findAllByRoleAndExperience(Integer page, Integer size, Integer sort, Integer role, Integer experience);

    /**
     * 获取所有的角色信息
     *
     * @return
     */
    List<RoleDTO> findAllRoles();

    /**
     * 获取所有的经验信息
     * @return
     */
    List<ExperienceDTO> findAllExperience();

}
