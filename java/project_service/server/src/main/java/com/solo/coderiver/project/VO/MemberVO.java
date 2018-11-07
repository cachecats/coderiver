package com.solo.coderiver.project.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * 团队阵容
 */
@Data
public class MemberVO implements Serializable {

    private static final long serialVersionUID = 48220746680875483L;

    //角色名称
    private String roleName;

    //需要的人数
    private Integer needNum;

    //实际已有人数
    private Integer actualNum;
}
