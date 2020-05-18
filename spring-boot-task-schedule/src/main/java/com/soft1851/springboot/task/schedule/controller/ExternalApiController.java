package com.soft1851.springboot.task.schedule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author YangJinG
 * @ClassName ExternalApiController
 * @Description TODO
 * @Date 2020/5/17  23:55
 * @Version 1.0
 **/

@Controller
public class ExternalApiController {
    @GetMapping("/external/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello external");
    }
}