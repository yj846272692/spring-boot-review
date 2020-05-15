package com.soft1851.springboot.task.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @ClassName Cron
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/5/15
 **/
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer cronId;

    @Column(name = "cron_name",nullable = false,length = 30)
    private  String cronName;

    @Column(name = "cron",nullable = false,length = 50)
    private  String cron;

}