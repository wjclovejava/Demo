package com.example.wjc.ssecurity1215.dao.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/25 10:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDO extends BaseDO {
    private String username;
    private String password;
}
