package com.xuecheng.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author: Feiyue
 * Date: 2019/9/25 17:49
 * Desc: SpringBoot启动类
 */

@SpringBootApplication
@EntityScan("com.xuecheng.framework.domain.cms") // SpringBoot注解，扫描实体类
@ComponentScan(basePackages={"com.xuecheng.api"}) // SpringBoot注解，扫描接口
@ComponentScan(basePackages={"com.xuecheng.manage_cms"}) // 扫描本项目下的所有类。 此注解可以不加。
public class ManageCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class);
    }
}
