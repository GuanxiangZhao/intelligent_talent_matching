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
@TableName("skill")
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "skill_id", type = IdType.AUTO)
    private Integer skillId;

    @TableField("skill_name")
    private String skillName;

    @TableField("skill_create_time")
    private Date skillCreateTime;

    @TableField("skill_update_time")
    private Date skillUpdateTime;
}
