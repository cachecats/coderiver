package com.solo.coderiver.project.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ProjectCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    public ProjectCategory() {
    }

    public ProjectCategory(Integer categoryType, String categoryName) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
