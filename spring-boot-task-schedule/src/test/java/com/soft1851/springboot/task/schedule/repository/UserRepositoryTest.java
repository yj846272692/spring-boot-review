package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void add(){
        User user = User.builder()
                .userName("846272692")
                .password("123456")
                .birthday(LocalDateTime.now())
                .mail("846272692@qq.com")
                .build();
        userRepository.save(user);
    }
    @Test
    void find(){
        List<User> users = userRepository.findUsersByBirthday();
        users.forEach(user -> System.out.println("今天生日的用户有："+user.getUserName()));
    }
}