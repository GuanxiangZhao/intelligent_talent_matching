package com.example.intelligent_talent_matching.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhao
 * @since 2026-05-14
 */
@Getter
@Setter
@ToString
@TableName("file")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "file_id", type = IdType.AUTO)
    private Integer fileId;

    @TableField("file_user_id")
    private Integer fileUserId;

    @TableField("file_name")
    private String fileName;

    @TableField("file_url")
    private String fileUrl;

    @TableField("file_type")
    private String fileType;

    @TableField("file_create_time")
    private Date fileCreateTime;

    @TableField("file_update_time")
    private Date fileUpdateTime;
}
