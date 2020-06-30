package com.lmy.friday.service.impl;
/**
 * @Project friday
 * @Package com.lmy.friday.service.impl
 * @author Administrator
 * @date 2020/6/29 22:27
 * @version V1.0
 */

import com.lmy.friday.dto.LoginUser;
import com.lmy.friday.entity.SysPermission;
import com.lmy.friday.entity.SysUser;
import com.lmy.friday.mapper.SysPermissionMapper;
import com.lmy.friday.mapper.SysUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @ClassName UserDetailsServiceImpl
 * @Description TODO
 * @date 2020/6/29 22:27
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selcetUserByUsername(username);
        if (sysUser == null) {
            throw new AuthenticationCredentialsNotFoundException("用户名不存在");
        } else if (sysUser.getStatus() == SysUser.Status.LOCKED) {
            throw new LockedException("用户被锁定,请联系管理员");
        } else if (sysUser.getStatus() == SysUser.Status.DISABLED) {
            throw new DisabledException("用户已作废");
        }

        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(sysUser, loginUser);

        List<SysPermission> permissions = sysPermissionMapper.selectByUserId(sysUser.getId());
        loginUser.setPermissions(permissions);

        return loginUser;

    }
}
