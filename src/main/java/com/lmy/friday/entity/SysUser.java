package com.lmy.friday.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-06-25 17:45:06
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 987351805334478204L;
    // ID
    private Integer id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 昵称
    private String nickname;
    // 头像
    private String headImgUrl;
    // 电话号码
    private String phone;
    // 手机号码
    private String telephone;
    // 邮箱
    private String email;
    // 生日
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    // 性别 1 为男 0 为女
    private Integer sex;
    // 状态
    private Integer status;
    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    public interface Status {
        int DISABLED = 0;
        int VALID = 1;
        int LOCKED = 2;
    }

}