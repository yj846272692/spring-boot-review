package com.soft1851.springboot.jpa.service.impl;

import com.soft1851.springboot.jpa.repository.UserRepository;
import com.soft1851.springboot.jpa.model.User;
import com.soft1851.springboot.jpa.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 8:12
 * @Description:
 */
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userDao;

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public User findByUserNameOrEmail(String username, String email) {
        return null;
    }

    @Override
    public Long deleteBYiD(Long id) {
        return null;
    }

    @Override
    public Long countByUserName(String userName) {
        return null;
    }

    @Override
    public List<User> findByEmailLike(String email) {
        return null;
    }

    @Override
    public User findByUserNameIgnoreCase(String userName) {
        return null;
    }

    @Override
    public List<User> findByUserNameOrderByEmailDesc(String email) {
        return null;
    }
}
