package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class AdminRepositoryTest {
    @Autowired
    private AdminRepository adminRepository;

    @Test
    void findByName() {
        Admin list = adminRepository.findByName("111");
        System.out.println(list);

    }

    @Test
    void findByNameOrScore() {
        Admin item = adminRepository.findByNameOrScore("1786711",56456);
        System.out.println(item);
    }
}