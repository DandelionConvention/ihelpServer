package com.services.products.ihelp.dao.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long serviceId;

    private Long userId;

    private Byte role;

    private Byte commentLevel;

    private String content;

    private String images;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public Byte getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Byte commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        sb.append(", serviceId=").append(serviceId);
        sb.append(", userId=").append(userId);
        sb.append(", role=").append(role);
        sb.append(", commentLevel=").append(commentLevel);
        sb.append(", content=").append(content);
        sb.append(", images=").append(images);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}