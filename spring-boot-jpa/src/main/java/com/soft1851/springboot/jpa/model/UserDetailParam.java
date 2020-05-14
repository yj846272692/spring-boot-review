package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 19:57
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDetailParam {
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
    private String introduction;

    @Column(nullable = false)
    private String realName;

    @Column
    private Integer minAge;

    @Column
    private Integer maxAge;
}
