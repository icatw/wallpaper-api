package com.icatw.wallpaperapi.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 壁纸用户表(User)实体类
 *
 * @author icatw
 * @since 2022-10-04 20:55:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("User")
public class User implements Serializable {
    private static final long serialVersionUID = 596718070708762847L;
    /**
     * 主键自增id
     */
    @TableId(value = "user_id" , type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 密码
     */
    @TableField(value = "password")
    @ApiModelProperty("密码")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @TableField(value = "sex")
    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private String sex;

    /**
     * 【是否启用账号】
     */
    @TableField(value = "status")
    @ApiModelProperty("【是否启用账号】")
    private Integer status;

    /**创建时间*/
    /**
     * 创建时间
     */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**修改时间*/
    /**
     * 修改时间
     */
    @TableField(value = "update_time" , fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("修改时间")
    private Date updateTime;

    /**
     * 最后登陆时间
     */
    @TableField(value = "last_login_time")
    @ApiModelProperty("最后登陆时间")
    private Date lastLoginTime;
}

