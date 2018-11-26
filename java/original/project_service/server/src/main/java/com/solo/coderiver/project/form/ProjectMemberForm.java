package com.solo.coderiver.project.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectMemberForm implements Serializable {

    private static final long serialVersionUID = 7615022451844986128L;

    private Integer userRole;

    private Integer count;

    public ProjectMemberForm() {
    }

    public ProjectMemberForm(Integer userRole, Integer count) {
        this.userRole = userRole;
        this.count = count;
    }
}
