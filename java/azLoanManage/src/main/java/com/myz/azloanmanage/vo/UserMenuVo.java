package com.myz.azloanmanage.vo;


import com.myz.azloanmanage.entity.SysMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("返回用户前端菜单参数")
public class UserMenuVo {
    @ApiModelProperty(value = "用户Id",dataType = "Long")
    private Long id;
    @ApiModelProperty(value = "用户名",dataType = "String")
    private String nickName;
    @ApiModelProperty(value = "密码",dataType = "String")
    private String password;
    @ApiModelProperty(value = "菜单列表")
    private List<SysMenu> sysMenuList;


}
