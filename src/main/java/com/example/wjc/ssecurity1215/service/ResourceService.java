package com.example.wjc.ssecurity1215.service;

import com.example.wjc.ssecurity1215.bean.Resource;
import com.example.wjc.ssecurity1215.dao.ResourceMapper;
import com.example.wjc.ssecurity1215.dao.model.ResourceDO;
import com.example.wjc.ssecurity1215.util.DozerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/18 11:40
 */
@Service
public class ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    public List<Resource> queryResourceByUserId(Integer userId){
        return DozerUtils.convertList(resourceMapper.queryResourceByUserId(userId),Resource.class);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,isolation =Isolation.READ_UNCOMMITTED )
    public void save(Resource resource){
        resourceMapper.save(DozerUtils.convert(resource,ResourceDO.class));
        int i=1/0;
    }
}
