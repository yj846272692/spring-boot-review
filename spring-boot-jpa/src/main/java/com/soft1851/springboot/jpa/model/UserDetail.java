package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 18:27
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long userId;
    @Column
    private Integer age;
    @Column
    private String realName;
    @Column
    private String status;
    @Column
    private String hobby;
    @Column
    private String introduction;
    @Column
    private String lastLoginIp;
}
