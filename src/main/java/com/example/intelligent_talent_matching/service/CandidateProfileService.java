package com.example.intelligent_talent_matching.service;

import com.example.intelligent_talent_matching.entity.CandidateProfile;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhao
 * @since 2026-05-14
 */
public interface CandidateProfileService extends IService<CandidateProfile> {

    //insert profile
    boolean insertProfile(CandidateProfile profile);

    //update profile
    boolean updateProfile(CandidateProfile profile);

    //delete profile
    boolean deleteProfile(Integer profileId);

    //select all profile
    List<CandidateProfile> selectProfiles();

    //select profile by id
    CandidateProfile selectProfileById(Integer profileId);

    //select profile by name
    List<CandidateProfile> selectProfileByName(String profileName);
}
