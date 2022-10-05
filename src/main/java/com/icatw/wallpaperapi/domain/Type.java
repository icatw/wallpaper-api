package com.icatw.wallpaperapi.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 壁纸分类表(Type)实体类
 *
 * @author icatw
 * @since 2022-10-04 20:55:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Type")
public class Type implements Serializable {
    private static final long serialVersionUID = 308464180268315918L;
    /**
     * 主键id
     */
    @TableId(value = "type_id" , type = IdType.AUTO)
    private Long typeId;

    /**
     * 分类名
     */
    @TableField(value = "type_name")
    @ApiModelProperty("分类名")
    private String typeName;

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
     * 逻辑删除（1删除，0未删除）
     */
    @TableField(value = "is_deleted")
    @ApiModelProperty("逻辑删除（1删除，0未删除）")
    private Integer isDeleted;
}

