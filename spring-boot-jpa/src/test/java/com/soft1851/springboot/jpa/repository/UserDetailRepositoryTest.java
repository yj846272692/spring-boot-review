package com.soft1851.springboot.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 20:31
 * @Description:
 */
@SpringBootTest
class UserDetailRepositoryTest {
    @Resource
    private UserDetailRepository userDetailRepository;

    @Test
    public void testUserInfo()  {
        List<UserInfo> userInfos= userDetailRepository.findUserInfo("骑车");
        for (UserInfo userInfo:userInfos){
            System.out.println("userInfo: "+userInfo.getUserName()+"-"+userInfo.getEmail()+"-"+userInfo.getHobby()+"-"+userInfo.getIntroduction());
        }
    }
}