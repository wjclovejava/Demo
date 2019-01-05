package com.example.wjc.ssecurity1215.service;

import com.example.wjc.ssecurity1215.controller.User;
import com.example.wjc.ssecurity1215.dao.UserMapper;
import com.example.wjc.ssecurity1215.util.DozerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/18 11:39
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    /**
     * 通过用户名查询User对象
     * @param username
     * @return
     */
    public User queryByUsername(String username){
        return DozerUtils.convert(userMapper.queryByUsername(username),User.class);
    }
}
