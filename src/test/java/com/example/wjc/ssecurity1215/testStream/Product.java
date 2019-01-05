package com.example.wjc.ssecurity1215.testStream;

import lombok.Data;

import java.util.List;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/30 16:08
 */
@Data
public class Product {
    /**
     * 产品编号
     */
    private Integer productId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品生产厂家
     */
    private List<String> productFactories;
    /**
     * 数量
     */
    private Integer count;
}
