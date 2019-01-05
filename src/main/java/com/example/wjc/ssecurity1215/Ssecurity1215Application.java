package com.example.wjc.ssecurity1215;

import com.example.wjc.ssecurity1215.config.CustomProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@PropertySource("classpath:/static/personconfig.properties")
@MapperScan({"com.example.wjc.ssecurity1215.dao"})
public class Ssecurity1215Application {

    public static void main(String[] args) {
        SpringApplication.run(Ssecurity1215Application.class, args);
    }

}

