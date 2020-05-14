package com.soft1851.springboot.jpa.repository.test2;

import com.soft1851.springboot.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: YangJinG
 * @Date: 2020/5/14 21:08
 * @Description:
 */
public interface StudentTest2Repository extends JpaRepository<Student,Long> {
    @Query(value = "select id,student_name,age from student  where clazz_id = ?1", nativeQuery = true)
    List<Student> findByClazzId(int id);
}
