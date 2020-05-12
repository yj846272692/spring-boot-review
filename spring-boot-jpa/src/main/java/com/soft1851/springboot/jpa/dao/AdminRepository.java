package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName AdminRepository
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/5/13
 **/
public interface AdminRepository extends JpaRepository<Admin, Long> {
    /**
     * 通过AdminName查询
     * @param name
     * @return name
     */
    Admin findByName(String name);

    /**
     * 根据name或score查询
     * @param name
     * @param score
     * @return
     */
    Admin findByNameOrScore(String name, Integer score);
}