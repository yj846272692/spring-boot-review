package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.Coder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName CodeRepository
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/5/18
 **/

public interface CoderRepository extends JpaRepository<Coder,Integer> {
}