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
@TableName("candidate_profile")
public class CandidateProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "profile_id", type = IdType.AUTO)
    private Integer profileId;

    @TableField("profile_name")
    private String profileName;

    @TableField("profile_age")
    private Integer profileAge;

    @TableField("profile_year")
    private Integer profileYear;

    @TableField("profile_tel")
    private String profileTel;

    @TableField("profile_email")
    private String profileEmail;

    @TableField("profile_localtion")
    private String profileLocaltion;

    @TableField("profile_major")
    private String profileMajor;

    @TableField("profile_introduction")
    private String profileIntroduction;

    @TableField("profile_create_time")
    private Date profileCreateTime;

    @TableField("profile_update_time")
    private Date profileUpdateTime;

    @TableField("profile_user_id")
    private Integer profileUserId;
}
