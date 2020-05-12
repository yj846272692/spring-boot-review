package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/5/13
 **/
@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue
    private Integer adminId;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Integer score;
}