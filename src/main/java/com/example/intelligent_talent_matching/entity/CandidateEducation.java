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
@TableName("candidate_education")
public class CandidateEducation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "education_id", type = IdType.AUTO)
    private Integer educationId;

    @TableField("education_school")
    private String educationSchool;

    @TableField("education_start_date")
    private Date educationStartDate;

    @TableField("education_end_date")
    private Date educationEndDate;

    @TableField("education_major")
    private String educationMajor;

    @TableField("education_create_time")
    private Date educationCreateTime;

    @TableField("education_update_time")
    private Date educationUpdateTime;

    @TableField("education_profile_id")
    private Integer educationProfileId;
}
