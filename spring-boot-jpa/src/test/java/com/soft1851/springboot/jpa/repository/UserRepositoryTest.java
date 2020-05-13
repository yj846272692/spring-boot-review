package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author YangJinG
 * @Description
 * @Date 2020/5/14
 */
@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;

    @Test
    void testSave() {
        User user = User.builder()
                .userName("user")
                .password("user")
                .nickName("github")
                .age(20)
                .regTime(LocalDateTime.now()).build();
        userRepository.save(user);

        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User testUser = User.builder()
                    .userName("user" + i)
                    .password("user" + i)
                    .nickName("nickName" + i)
                    .age(new Random().nextInt(50))
                    .regTime(LocalDateTime.now()).build();
            users.add(testUser);
        }
        userRepository.saveAll(users);
//        assertEquals(21, userRepository.findAll().size());
    }

    @Test
    void testUpdate() {
        //使用save活saveAndFlush方法更新数据，必须要提供所有字段值，否则该字段为空
        User user = User.builder()
                .userId(1L)
                .userName("修改后姓名")
                .password("修改后密码")
                .nickName("修改后昵称")
                .age(12)
                .regTime(LocalDateTime.now()).build();
        userRepository.saveAndFlush(user);
        //可以自定义SQL实现更新
        int n = userRepository.updateNickName("新昵称", 1L);
        assertEquals(1, n);
    }


    @Test
    void testInsert() {
        //自定义插入
        int n = userRepository.insertUser("123", "123", "自定义");
        assertEquals(1, n);
    }


    @Test
    void testDelete() {
        //自带删除方法
        userRepository.deleteById(77L);
    }

    @Test
    void testSelect() {
        // 查询所有
        userRepository.findAll().forEach(user -> log.info(user.toString()));
        // 分页查询全部，返回封装了的分页信息， jpa页码从0开始
        Page<User> pageInfo = userRepository.findAll(
                PageRequest.of(1, 3, Sort.Direction.ASC, "userId"));
        log.info("总记录数： {}", pageInfo.getTotalElements());
        log.info("当前页记录数： {}", pageInfo.getNumberOfElements());
        log.info("每页记录数： {}", pageInfo.getSize());
        log.info("获取总页数： {}", pageInfo.getTotalPages());
        log.info("查询结果： {}", pageInfo.getContent());
        log.info("当前页（从0开始计）： {}", pageInfo.getNumber());
        log.info("是否为首页： {}", pageInfo.isFirst());
        log.info("是否为尾页： {}", pageInfo.isLast());
        // 条件查询
        User user = User.builder().userName("saber").build();
        List<User> users = userRepository.findAll(Example.of(user));
        log.info("满足条件的记录有：");
        users.forEach(user1 -> log.info(user1.toString()));
        // 单个查询
        User user1 = User.builder().userId(2L).build();
        Optional<User> optionalUser = userRepository.findOne(Example.of(user1));
        log.info("单个查询结果： {}", optionalUser.orElse(null));
    }

    //根据方法名解析的基础功能
    @Test
    void findByUserNameAndPassword() {

        User user = userRepository.findByUserNameAndPassword("333","333");
        log.info(String.valueOf(user));
    }

    @Test
    void findByNickName() {
        List<User> users = userRepository.findByNickName("nickName");
        users.forEach(user -> log.info(user.toString()));
    }

    @Test
    void findUsersByAgeGreaterThan() {
        List<User> users = userRepository.findUsersByAgeGreaterThan(20);
        users.forEach(user -> log.info(user.toString()));
    }

    @Test
    void  findById() {
        User user = userRepository.findById(1L);
        log.info(user.toString());
    }
}