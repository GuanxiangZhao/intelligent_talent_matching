package com.example.intelligent_talent_matching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.intelligent_talent_matching.entity.CandidateProfile;
import com.example.intelligent_talent_matching.mapper.CandidateProfileMapper;
import com.example.intelligent_talent_matching.service.CandidateProfileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhao
 * @since 2026-05-14
 */
@Service
public class CandidateProfileServiceImpl extends ServiceImpl<CandidateProfileMapper, CandidateProfile> implements CandidateProfileService {

    @Resource
    CandidateProfileMapper candidateProfileMapper;

    @Override
    public boolean insertProfile(CandidateProfile profile) {
        int result = candidateProfileMapper.insert(profile);
        return result > 0;
    }

    @Override
    public boolean updateProfile(CandidateProfile profile) {
        int result = candidateProfileMapper.updateById(profile);
        return result > 0;
    }

    @Override
    public boolean deleteProfile(Integer profileId) {
        int result = candidateProfileMapper.deleteById(profileId);
        return result > 0;
    }

    @Override
    public List<CandidateProfile> selectProfiles() {
        QueryWrapper<CandidateProfile> qw = new QueryWrapper<>();
        List<CandidateProfile> candidateProfiles = candidateProfileMapper.selectList(qw);
        return candidateProfiles;
    }

    @Override
    public CandidateProfile selectProfileById(Integer profileId) {
        QueryWrapper<CandidateProfile> qw = new QueryWrapper<>();
        qw.eq("profile_id", profileId);
        CandidateProfile candidateProfile = candidateProfileMapper.selectOne(qw);
        return candidateProfile;
    }

    @Override
    public List<CandidateProfile> selectProfileByName(String profileName) {
        QueryWrapper<CandidateProfile> qw = new QueryWrapper<>();
        qw.like("profile_name", profileName);
        List<CandidateProfile> candidateProfiles = candidateProfileMapper.selectList(qw);
        return candidateProfiles;
    }
}
