package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.User;

import java.util.List;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 8:03
 * @Description:
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根据用户名或者邮箱查询
     * @param username
     * @param email
     * @return
     */
    User findByUserNameOrEmail(String username,String email);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    Long deleteBYiD(Long id);

    /**
     * 统计同一用户名的用户数量
     * @param userName
     * @return
     */
    Long countByUserName(String userName);

    /**
     * 根据邮箱的模糊查询
     * @param email
     * @return
     */
    List<User> findByEmailLike(String email);

    /**
     * 按用户名查找忽略大小写
     * @param userName
     * @return
     */
    User findByUserNameIgnoreCase(String userName);

    /**
     * 根据用户名查询用户，以邮箱降序排列
     * @param email
     * @return
     */
    List<User> findByUserNameOrderByEmailDesc(String email);
}
