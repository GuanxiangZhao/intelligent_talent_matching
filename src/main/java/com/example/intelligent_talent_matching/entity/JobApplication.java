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
@TableName("job_application")
public class JobApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "application_id", type = IdType.AUTO)
    private Integer applicationId;

    @TableField("application_candidate_id")
    private Integer applicationCandidateId;

    @TableField("application_employer_id")
    private Integer applicationEmployerId;

    @TableField("application_job_id")
    private Integer applicationJobId;

    @TableField("application_create_time")
    private Date applicationCreateTime;

    @TableField("application_update_time")
    private Date applicationUpdateTime;
}
