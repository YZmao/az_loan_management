package com.myz.azloanmanage.util;

import com.myz.azloanmanage.entity.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    /**
     * 获取用户名
     * @return
     */
    public static String getUsername() {
        try {
            return ((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取用户ID
     * @return
     */
    public static Long getUserId() {
        try {
            return ((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取用户信息
     * @return
     */
    public static SysUser getUserInfo() {
        try {
            return (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }


}
