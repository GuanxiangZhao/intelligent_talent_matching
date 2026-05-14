package com.example.intelligent_talent_matching.service.impl;

import com.example.intelligent_talent_matching.entity.CandidateProfile;
import com.example.intelligent_talent_matching.service.CandidateProfileService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class CandidateProfileServiceImplTest {

    @Resource
    CandidateProfileService candidateProfileService;

    @Test
    public void insertProfile() {
        CandidateProfile candidateProfile = new CandidateProfile();
        candidateProfile.setProfileName("test");
        candidateProfile.setProfileAge(28);
        candidateProfile.setProfileTel("1234567890");
        boolean r = candidateProfileService.insertProfile(candidateProfile);
        System.out.println(r);
    }

    @Test
    public void updateProfile() {
        CandidateProfile candidateProfile = new CandidateProfile();
        candidateProfile.setProfileName("test1");
        candidateProfile.setProfileId(1);
        candidateProfile.setProfileEmail("1000@123.com");
        candidateProfile.setProfileTel("13591123611");
        boolean r = candidateProfileService.updateProfile(candidateProfile);
        System.out.println(r);

    }

    @Test
    public void deleteProfile() {
    }

    @Test
    public void selectProfiles() {
        List<CandidateProfile> candidateProfiles = candidateProfileService.selectProfiles();
        for (CandidateProfile candidateProfile : candidateProfiles) {
            System.out.println(candidateProfile);
        }
    }

    @Test
    public void selectProfileById() {
        CandidateProfile candidateProfile = candidateProfileService.selectProfileById(2);
        System.out.println(candidateProfile);
    }

    @Test
    public void selectProfileByName() {
    }
}