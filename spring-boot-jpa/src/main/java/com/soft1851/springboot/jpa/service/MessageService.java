package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.Message;

import java.util.List;

/**
 * @Author: YangJinG
 * @Date: 2020/5/12 20:43
 * @Description:
 */
public interface MessageService {
    void save(Message message);

    void batchSave(List<Message> messages);

    void delete(Integer id);

    void batchDelete(List<Message> messages);

    void deleteAll();

    void update(Message message);

    void batchUpdate(List<Message> messages);

    long count();

    Message getMessage(Integer id);

    List<Message> getAll();
}
