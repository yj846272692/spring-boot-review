package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @Author: YangJinG
 * @Date: 2020/5/13 22:24
 * @Description:
 */
public interface PeopleRepository extends JpaSpecificationExecutor<People>, JpaRepository<People, Long> {
    /**
     * 人物与地址的一对一
     * @param id
     * @return
     */
    People findPeopleById(long id);
}
