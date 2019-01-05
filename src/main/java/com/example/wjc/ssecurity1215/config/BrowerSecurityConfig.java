package com.example.wjc.ssecurity1215.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

/**
 * @Author: wjc
 * @Description:  安全策略配置
 *
 * @Date: created in 2018/12/17 16:53
 */
@Configuration
@EnableWebSecurity(debug = true)
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private  UserDetailsService userDetailsService;

    @Autowired
    SecuritySettings securitySettings;
    @Autowired
    LoginSuccessHandler loginSuccessHandler;
    /**登录认证*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**安全策略配置*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设置游客可以访问的URI
        if (StringUtils.isNotBlank(securitySettings.getPermitall())) {
            String[] split = securitySettings.getPermitall().split(",");
            System.out.println("------------"+ Arrays.toString(split));
            http.authorizeRequests().antMatchers(split).permitAll();
        }

        http.formLogin() //  定义当需要用户登录时候，转到的登录页面。
                .successHandler(loginSuccessHandler)
                .and()
                .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
                .anyRequest() // 任何请求,登录后可以访问
                .authenticated().and().csrf().disable();
    }

    /***设置不拦截规则*/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()  //配置忽略请求路径
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/app/**/*.{js,html}")
                .antMatchers("/i18n/**")
                .antMatchers("/content/**")
                .antMatchers("/swagger-ui/index.html")
                .antMatchers("/testfunction/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
