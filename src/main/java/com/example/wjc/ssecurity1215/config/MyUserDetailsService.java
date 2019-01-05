package com.example.wjc.ssecurity1215.config;

import com.example.wjc.ssecurity1215.controller.User;
import com.example.wjc.ssecurity1215.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/17 17:38
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("username:"+username);
        User userInfo = userService.queryByUsername(username);
        if(null==userInfo){
            throw  new UsernameNotFoundException("用户名不存在");
        }
        String password = passwordEncoder.encode(userInfo.getPassword());
        logger.info("password: {}", password);
        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        User user = new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,dev"));
        return user;
    }


}
