package com.example.wjc.ssecurity1215.dao.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/25 10:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResourceDO extends BaseDO {
    private String url;
    private String resName;
    private String description;
    private Integer pid;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
