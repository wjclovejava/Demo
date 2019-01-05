package com.example.wjc.ssecurity1215.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/24 11:04
 */
@Data
@ConfigurationProperties(prefix = "good.person")
@Component
public class CustomProperties {
    private Map<String, String> goodman1;
    private Map<String, String> goodman2;
    private Map<String, String> goodman3;
}
