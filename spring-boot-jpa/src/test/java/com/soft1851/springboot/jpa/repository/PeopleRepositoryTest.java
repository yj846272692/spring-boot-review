package com.soft1851.springboot.jpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 22:32
 * @Description:
 */
@SpringBootTest
@Slf4j
class PeopleRepositoryTest {
    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    void getPeopleInfo() {
        System.out.println(peopleRepository.findPeopleById(1L));
    }
}