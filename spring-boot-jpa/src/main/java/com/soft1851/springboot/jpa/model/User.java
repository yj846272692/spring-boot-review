package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YangJinG
 * @Date: 2020/5/12 20:39
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@NamedQueries({
//        @NamedQuery(name = "User.findByPassWord", query = "select u from User u where u.passWord = ?1"),
//        @NamedQuery(name = "User.findByNickName", query = "select u from User u where u.nickName = ?1"),
//})
public class User {
    /**
     * 主键，策略为自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * nullable = false为非空约束，unique = true是唯一约束
     */
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 32)
    private String nickName;

    @Column
    private Integer age;

    @Column
    private LocalDateTime regTime;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorityList = new ArrayList<>();
}
