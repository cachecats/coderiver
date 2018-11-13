package com.solo.coderiver.project.utils;

import com.solo.coderiver.project.enums.RoleEnum;

/**
 * 角色工具类
 */
public class RoleUtils {

    /**
     * 根据角色码返回角色名
     *
     * @param code
     * @return
     */
    public static String getRoleNameByRoleCode(Integer code) {
        RoleEnum[] values = RoleEnum.values();
        for (RoleEnum role : values) {
            if (role.getCode().equals(code)) {
                return role.getMsg();
            }
        }
        return "";
    }
}
