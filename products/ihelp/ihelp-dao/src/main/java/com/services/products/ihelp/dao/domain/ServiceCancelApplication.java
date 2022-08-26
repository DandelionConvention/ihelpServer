package com.services.products.ihelp.dao.domain;

import java.time.LocalDateTime;

public class ServiceCancelApplication {
    private Long id;

    private Long serviceId;

    private Long serviceApplicationId;

    private Integer serviceCancelReasonId;

    private String description;

    private String images;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getServiceApplicationId() {
        return serviceApplicationId;
    }

    public void setServiceApplicationId(Long serviceApplicationId) {
        this.serviceApplicationId = serviceApplicationId;
    }

    public Integer getServiceCancelReasonId() {
        return serviceCancelReasonId;
    }

    public void setServiceCancelReasonId(Integer serviceCancelReasonId) {
        this.serviceCancelReasonId = serviceCancelReasonId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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
        sb.append(", id=").append(id);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", serviceApplicationId=").append(serviceApplicationId);
        sb.append(", serviceCancelReasonId=").append(serviceCancelReasonId);
        sb.append(", description=").append(description);
        sb.append(", images=").append(images);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}