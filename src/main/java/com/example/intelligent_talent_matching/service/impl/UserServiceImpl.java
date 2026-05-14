package com.example.intelligent_talent_matching.service.impl;

import com.example.intelligent_talent_matching.entity.User;
import com.example.intelligent_talent_matching.mapper.UserMapper;
import com.example.intelligent_talent_matching.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  Service Implements Class
 * </p>
 *
 * @author Zhao
 * @since 2026-05-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
