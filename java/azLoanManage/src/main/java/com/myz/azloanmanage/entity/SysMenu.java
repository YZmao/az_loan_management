package com.myz.azloanmanage.entity;


import lombok.Data;

@Data
public class SysMenu {
    private Long id;

    private String path;

    private String icon;

    private String title;

    private String component;

    private String parentId;


}