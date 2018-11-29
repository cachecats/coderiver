package com.solo.coderiver.user.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegisterForm {

    //邮箱
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    //密码
    @NotEmpty(message = "密码不能为空")
    private String password;

    //昵称
    @NotEmpty(message = "昵称不能为空")
    private String name;

    //角色码
    @NotNull(message = "角色不能为空")
    private Integer role;

    //经验码
    @NotNull(message = "经验不能为空")
    private Integer experience;
}
