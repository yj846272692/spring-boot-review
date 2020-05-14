package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: YangJinG
 * @Date: 2020/5/12 20:40
 * @Description:
 */
@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50) // 映射为字段，值不能为空
    private String title;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch = FetchType.LAZY) // 懒加载
    @Column(nullable = false) // 映射为字段，值不能为空
    private String content;//文章全文内容


}
