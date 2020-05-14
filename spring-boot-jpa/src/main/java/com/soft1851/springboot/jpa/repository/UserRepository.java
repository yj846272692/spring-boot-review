package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 7:51
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据方法名解析：按userName和password相等查询唯一记录
     *
     * @param userName
     * @param password
     * @return
     */
    User findByUserNameEqualsAndPasswordEquals(String userName, String password);

    /**
     * 根据方法名解析：按nickName模糊查询一组记录
     *
     * @param nickName
     * @return
     */
    List<User> findUsersByNickNameLike(String nickName);

    /**
     * 根据方法名解析：查询年龄大于指定age的所有用户
     * @param age
     * @return
     */
    List<User> findUsersByAgeGreaterThan(int age);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return User
     */
    User findByUserName(String userName);

    /**
     * 关键字查询用户
     * @param username
     * @param email
     * @return List<User>
     */
    List<User> findByUserNameOrEmail(String username,String email);

    /**
     *
     * @param id
     * @return
     */
//    Long deleteById(Long id);

    /**
     * 根据用户名统计
     * @param userName
     * @return
     */
    Long countByUserName(String userName);

    /**
     * 根据邮箱模糊查询用户
     * @param email
     * @return
     */
    List<User> findByEmailLike(String email);

    /**
     * 根据用户名查询用户，忽略大小写
     * @param userName
     * @return
     */
    User findByUserNameIgnoreCase(String userName);

    /**
     * 根据用户名查询用户，根据邮箱降序
     * @param email
     * @return
     */
    List<User> findByUserNameOrderByEmailDesc(String email);


    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    /**
     * 查询中有多个参数的时候 Pageable 建议作为最后一个参数传入。
     * @param nickName
     * @param pageable
     * @return
     */
    @Query(value ="select * from user u where u.nick_name = ?1", nativeQuery = true)
    Page<User> findByNickName(String nickName, Pageable pageable);

    @Query(value ="select * from user u where u.nick_name = ?1 and u.email = ?2", nativeQuery = true)
    Slice<User> findByNickNameAndEmail(String nickName, String email, Pageable pageable);

//    @Query("select u from User u where u.nickName = :nickName")
//    Page<User> findByNickName(@Param("nickName") String nickName, Pageable pageable);


    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Modifying
    @Query("update User set userName = ?1 where id = ?2")
    int modifyById(String  userName, Long id);

//    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
//    @Modifying
//    @Query("delete from User where id = ?1")
//    void deleteById(Long id);


    @Query("select u from User u where u.id = ?1")
    User findById(long id);


    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update user set nick_name = ?1 where id = ?2", nativeQuery = true)
    int updateNickName(String nickName, long id);


    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "insert into user(user_name, password,email) values (:userName, :password,:email)", nativeQuery = true)
    int insertUser(@Param("userName") String userName, @Param("password") String password, @Param("email") String email);


//自定义查询
//    User findFirstByOrderByLastnameAsc();
//    User findTopByOrderByAgeDesc();
//    Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
//    List<User> findFirst10ByLastname(String lastname, Sort sort);
//    List<User> findTop10ByLastname(String lastname, Pageable pageable);

    List<User> findFirst10ByNickName(String nickName , Pageable pageable);

    @Query(value = "select user_name,age,nick_name from user where id = ?1",nativeQuery = true)
    User findUserById(long id);

}
