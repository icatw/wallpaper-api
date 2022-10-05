package com.icatw.wallpaperapi.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 壁纸表(Paper)实体类
 *
 * @author icatw
 * @since 2022-10-04 20:55:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Paper")
public class Paper implements Serializable {
    private static final long serialVersionUID = -19517476745744430L;
    /**
     * 壁纸id
     */
    @TableId(value = "paper_id" , type = IdType.AUTO)
    private Long paperId;

    /**
     * 壁纸名
     */
    @TableField(value = "paper_name")
    @ApiModelProperty("壁纸名")
    private String paperName;

    /**
     * 壁纸url
     */
    @TableField(value = "paper_url")
    @ApiModelProperty("壁纸url")
    private String paperUrl;

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

    /**
     * 分类id
     */
    @TableField(value = "type_id")
    @ApiModelProperty("分类id")
    private Long typeId;

    /**
     * 图片分辨率（width*height）
     */
    @TableField(value = "paper_size")
    @ApiModelProperty("图片分辨率（width*height）")
    private String paperSize;
}

