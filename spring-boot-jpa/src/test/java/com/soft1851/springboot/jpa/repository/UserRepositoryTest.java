package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Authority;
import com.soft1851.springboot.jpa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/13 15:13
 * @Description:
 */
@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;

    /**
     * 使用该save方法进行更新时会发现，更新全部字段时会正常实现，可是在只更新部分字段时，会发现没有更新的字段被置为null；
     */
    @Test
    void testSave(){
        List<User> userList = new ArrayList<>();
        for (int i = 0;i < 30 ; i++){
            User user= User.builder()
                    .userName("user"+i)
                    .email("11111"+i+"@qq.com")
                    .password("232623")
                    .nickName("name"+i)
                    .age(10+i)
                    .regTime(LocalDateTime.now())
                    .build();
            userList.add(user);
        }
        System.out.println(userRepository.saveAll(userList).size());

    }

    /**
     * 默认方法
     */
    @Test
    public void testBaseQuery() {
//        System.out.println(userRepository.findAll().size());
//
//        assertNotNull(userRepository.findById(1L).get().getAge());

        User saveUser= User.builder()
                .userName("测试")
                .email("test")
                .password("232623")
                .nickName("test")
                .age(10)
                .regTime(LocalDateTime.now())
                .build();
        userRepository.save(saveUser);
//
//        User delUser = User.builder()
//                .userName("测试")
//                .email("test")
//                .password("232623")
//                .nickName("test")
//                .age(10)
//                .regTime(LocalDateTime.now())
//                .build();
//        userRepository.delete(delUser);

//        userRepository.count();
//
//        assert(userRepository.existsById(1l));

    }

    @Test
    void findByUserNameEqualsAndPasswordEquals() {
        User resultUser = userRepository.findByUserNameEqualsAndPasswordEquals("user1","232623");
        assertNotNull(resultUser.getId());
    }

    @Test
    void findUsersByNickNameLike() {
        List<User> userList = userRepository.findUsersByNickNameLike("name1");
        userList.forEach(user -> System.out.println(user.getUserName()));
    }

    @Test
    void findUsersByAgeGreaterThan() {
        System.out.println(userRepository.findUsersByAgeGreaterThan(15).size());
    }

    @Test
    void findByUserName() {
        assertNotNull(userRepository.findByUserName("user1").getEmail());
    }

    @Test
    void findByUserNameOrEmail() {
        List<User> userList = userRepository.findByUserNameOrEmail("user","111111@qq.com");
        assertEquals(userList.size(),1);
    }

    @Test
    void countByUserName() {
        System.out.println(userRepository.countByUserName("user1"));
    }

    @Test
    void findByEmailLike() {
        System.out.println(userRepository.findByEmailLike("111111@qq.com").size());
    }


    /**
     * https://blog.csdn.net/qq_35953966/article/details/104061854
     */
    @Test
    void findALL() {
        int page = 1 ,size = 2;
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        userRepository.findAll().forEach(user -> log.info(user.toString()));
        Page<User> pageInfo  =  userRepository.findALL(pageable);
        log.info("总记录数： {}", pageInfo.getTotalElements());
        log.info("当前页记录数： {}", pageInfo.getNumberOfElements());
        log.info("每页记录数： {}", pageInfo.getSize());
        log.info("获取总页数： {}", pageInfo.getTotalPages());
        log.info("查询结果： {}", pageInfo.getContent());
        log.info("当前页（从0开始计）： {}", pageInfo.getNumber());
        log.info("是否为首页： {}", pageInfo.isFirst());
        log.info("是否为尾页： {}", pageInfo.isLast());

    }

    @Test
    void findByNickName() {
        int page=1,size=2;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        userRepository.findByNickName("name1", pageable);
    }

    @Test
    void findByNickNameAndEmail() {
        int page=1,size=2;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Slice<User> users =  userRepository.findByNickNameAndEmail("name1","222222@qq.com",pageable);
        System.out.println(users.getSize());
    }

    @Test
    void modifyById() {
        userRepository.modifyById("test",1L);
    }

    @Test
    void findById() {
        System.out.println(userRepository.findById(1l).getUserName());
    }

    @Test
    void updateNickName() {
        userRepository.updateNickName("test",1l);
    }

    @Test
    void insertUser() {
        userRepository.insertUser("test2","123456","24525245");
    }

    @Test
    void findFirst10ByNickName() {
        int page=0,size=2;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        System.out.println(userRepository.findFirst10ByNickName("name5",pageable).size());
    }

    @Test
    void testManyToMany(){
        System.out.println("***************************************");
        User user = userRepository.findById(1);
        System.out.println(user.getNickName()+","+user.getUserName()+","+user.getAge());
        List<Authority> authorityList = user.getAuthorityList();
        authorityList.forEach(authority -> {
            System.out.println(authority.getName()+","+authority.getId());
        });

    }
}