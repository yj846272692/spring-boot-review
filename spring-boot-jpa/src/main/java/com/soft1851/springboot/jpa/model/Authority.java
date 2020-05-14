package com.soft1851.springboot.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: YangJinG
 * @Date: 2020/5/12 20:39
 * @Description:
 */
@Data
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限名
     */
    @Column(nullable = false)
    private String name;

    /**
     * 拥有权限的用户列表
     */
//    @ManyToMany(mappedBy = "authorityList")
//    private List<User> userList;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<User> userList;
}