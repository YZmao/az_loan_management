package com.myz.azloanmanage.mapper;

import com.myz.azloanmanage.entity.RolesPermissions;

public interface RolesPermissionsMapper {
    int insert(RolesPermissions record);

    int insertSelective(RolesPermissions record);
}