package com.example.wjc.ssecurity1215.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/18 11:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends Base {
    private String roleName;
    private String description;
}
