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
@TableName("candidate_experience")
public class CandidateExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "experience_id", type = IdType.AUTO)
    private Integer experienceId;

    @TableField("experience_company")
    private String experienceCompany;

    @TableField("experience_job")
    private String experienceJob;

    @TableField("experience_start_date")
    private Date experienceStartDate;

    @TableField("experience_end_date")
    private Date experienceEndDate;

    @TableField("experience_create_time")
    private Date experienceCreateTime;

    @TableField("experience_update_time")
    private Date experienceUpdateTime;

    @TableField("experience_profile_id")
    private Integer experienceProfileId;
}
