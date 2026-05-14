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
@TableName("employer_profile")
public class EmployerProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "candidate_skill_id", type = IdType.AUTO)
    private Integer candidateSkillId;

    @TableField("candidate_skill_profile_id")
    private Integer candidateSkillProfileId;

    @TableField("candidate_skill_skill_id")
    private Integer candidateSkillSkillId;
}
