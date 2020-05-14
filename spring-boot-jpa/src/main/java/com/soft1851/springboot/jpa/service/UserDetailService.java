package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.UserDetail;
import com.soft1851.springboot.jpa.model.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 18:28
 * @Description:
 */
public interface UserDetailService {
    /**
     *
     * @param detailParam
     * @param pageable
     * @return
     */
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
