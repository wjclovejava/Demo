package com.example.wjc.ssecurity1215.dao;


import com.example.wjc.ssecurity1215.dao.model.ResourceDO;

import java.util.List;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/25 10:10
 */
public interface ResourceMapper {

    List<ResourceDO> queryResourceByUserId(Integer userId);

    void save(ResourceDO resourceDO);
}
