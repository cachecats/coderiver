package com.solo.coderiver.user.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TeamApplyForm implements Serializable {

    private static final long serialVersionUID = 7205473065180802892L;

    @NotEmpty(message = "项目id projectId 不能为空")
    private String projectId;

    @NotEmpty(message = "申请者id userId 不能为空")
    private String userId;

    @NotNull(message = "角色不能为空")
    private Integer role;

    private String comments;


}
