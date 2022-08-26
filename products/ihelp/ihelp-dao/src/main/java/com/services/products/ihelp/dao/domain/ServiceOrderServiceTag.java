package com.services.products.ihelp.dao.domain;

import java.time.LocalDateTime;

public class ServiceOrderServiceTag {
    private Long serviceOrderId;

    private Integer serviceTagId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(Long serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public Integer getServiceTagId() {
        return serviceTagId;
    }

    public void setServiceTagId(Integer serviceTagId) {
        this.serviceTagId = serviceTagId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serviceOrderId=").append(serviceOrderId);
        sb.append(", serviceTagId=").append(serviceTagId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}