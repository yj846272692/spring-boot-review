package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author YangJinG
 * @Description 基础的UserRepository，从父接口继承CRUD findBy返回一个User，findUsersBy返回一组User
 * @Date 2020/5/13
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据方法名解析：按userName和password查询唯一记录
     *
     * @param userName
     * @param password
     * @return user
     */
    User findByUserNameAndPassword(String userName, String password);

    /**
     * 根据方法名解析：按nickName模糊查询一组记录
     *
     * @param nickName
     * @return List<User>
     */
    List<User> findByNickName(String nickName);

    /**
     * 根据方法名解析：查询年龄大于指定age的所有用户
     *
     * @param age
     * @return List<User>
     */
    List<User> findUsersByAgeGreaterThan(int age);

    /**
     * 自定义SQL查询，类似 Hibernate的 HQL语法，在接口上使用 @Query
     *
     * @param userId
     * @return User
     */
    @Query("select u from User u where u.userId = ?1")
    User findById(long userId);

    /**
     * 按id修改nickName
     *
     * @param nickName
     * @param userId
     * @return int
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update user set nick_name = ?1 where user_id = ?2", nativeQuery = true)
    int updateNickName(String nickName, long userId);


    /**
     * 插入
     *
     * @param userName
     * @param password
     * @param nickName
     * @return int
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "insert into user(user_name, password,nick_name) values (:userName, :password,:nickName)", nativeQuery = true)
    int insertUser(@Param("userName") String userName, @Param("password") String password, @Param("nickName") String nickName);

}
