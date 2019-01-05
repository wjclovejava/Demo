package com.example.wjc.ssecurity1215.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wjc
 * @Description:  自定义配置类
 * @Date: created in 2018/12/25 14:39
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecuritySettings {
    /**允许访问的URL，多个用逗号分隔*/
    private String permitall;
}
