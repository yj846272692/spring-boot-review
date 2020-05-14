package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Student;
import com.soft1851.springboot.jpa.repository.test1.StudentTest1Repository;
import com.soft1851.springboot.jpa.repository.test2.StudentTest2Repository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: YangJing
 * @Date: 2020/5/14
 * @Description:
 */
@SpringBootTest
@Slf4j
class StudentRepositoryTest {
    @Resource
    private StudentTest1Repository userTest1Repository;
    @Resource
    private StudentTest2Repository userTest2Repository;

    @Test
    void test(){
        List<Student> studentList1 = userTest1Repository.findByClazzId(1);
        System.out.println("数据源1");
        studentList1.forEach(student -> System.out.println(student.getStudentName()));
        List<Student> studentList2 = userTest2Repository.findByClazzId(1);
        System.out.println("数据源2");
        studentList2.forEach(student -> System.out.println(student.getStudentName()));
    }

}
