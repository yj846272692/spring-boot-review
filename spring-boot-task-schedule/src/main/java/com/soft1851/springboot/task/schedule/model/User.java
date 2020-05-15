package com.soft1851.springboot.task.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/5/15
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "birthday",nullable = false)
    private LocalDateTime birthday;

    @Column(name = "mail",nullable = false)
    private String mail;
}