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
@TableName("job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "job_id", type = IdType.AUTO)
    private Integer jobId;

    @TableField("job_employer_id")
    private Integer jobEmployerId;

    @TableField("job_name")
    private String jobName;

    @TableField("job_description")
    private String jobDescription;

    @TableField("job_requirements")
    private String jobRequirements;

    @TableField("job_min_salary")
    private Double jobMinSalary;

    @TableField("job_max_salary")
    private Double jobMaxSalary;

    @TableField("job_count")
    private Integer jobCount;

    @TableField("job_create_time")
    private Date jobCreateTime;

    @TableField("job_update_time")
    private Date jobUpdateTime;
}
