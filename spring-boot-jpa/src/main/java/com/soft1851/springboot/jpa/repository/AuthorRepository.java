package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 23:38
 * @Description:
 */
public interface AuthorRepository extends JpaSpecificationExecutor<Author>, JpaRepository<Author, Long> {
    /**
     * 作者与文章的一对多
     * @param id
     * @return
     */
    List<Author> findAuthorByIdEquals(long id);

}
