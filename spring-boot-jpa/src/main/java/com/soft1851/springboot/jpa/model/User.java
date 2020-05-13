package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author YangJinG
 * @Description
 * @Date 2020/5/12
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(length = 32)
    private String nickName;
    @Column(nullable = false)
    private String password;
    @Column
    private Integer age;
    @Column
    private LocalDateTime regTime;
}
