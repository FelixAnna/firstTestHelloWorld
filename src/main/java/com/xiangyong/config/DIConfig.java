package com.xiangyong.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yuxiangyong on 2017/5/6.
 */
@Configuration
@ComponentScan(basePackageClasses = {
        com.xiangyong.controller.ContactController.class
        ,com.xiangyong.entity.ContactInfo.class
        ,com.xiangyong.repository.ContactRepository.class
        ,com.xiangyong.utils.ControlllerAdvice.class
})
public class DIConfig {
}
