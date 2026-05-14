package com.example.intelligent_talent_matching.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

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
@TableName("job_skill")
public class JobSkill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "job_skill_id", type = IdType.AUTO)
    private Integer jobSkillId;

    @TableField("job_skill_job_id")
    private Integer jobSkillJobId;

    @TableField("job_skill_skill_id")
    private Integer jobSkillSkillId;
}
