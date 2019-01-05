package com.example.wjc.ssecurity1215.dao;


import com.example.wjc.ssecurity1215.dao.model.UserDO;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/24 14:17
 */
public interface UserMapper {
    UserDO queryByUsername(String username);
}
