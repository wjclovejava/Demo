package com.example.wjc.ssecurity1215.dao.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/18 11:40
 */
@Data
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -6802123687884531762L;
    /**
     * 主键id
     */
    protected Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /** 创建人id */
    private Integer createEmpId;

    /** 修改人id */
    private Integer modifyEmpId;

}
