package com.services.products.ihelp.dao.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServiceOrder {
    private Long id;

    private Byte cancelReason;

    private Byte serviceStatus;

    private Long clientId;

    private Long servantId;

    private String content;

    private LocalDateTime serviceTime;

    private Byte serviceDuration;

    private String phone;

    private Integer region;

    private String province;

    private String city;

    private String county;

    private String detailedAddress;

    private String lng;

    private String lat;

    private BigDecimal integral;

    private BigDecimal tip;

    private LocalDateTime passTime;

    private LocalDateTime finishedTime;

    private Integer readingCount;

    private Integer commitCount;

    private Boolean isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(Byte cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Byte getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(Byte serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getServantId() {
        return servantId;
    }

    public void setServantId(Long servantId) {
        this.servantId = servantId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(LocalDateTime serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Byte getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(Byte serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public BigDecimal getTip() {
        return tip;
    }

    public void setTip(BigDecimal tip) {
        this.tip = tip;
    }

    public LocalDateTime getPassTime() {
        return passTime;
    }

    public void setPassTime(LocalDateTime passTime) {
        this.passTime = passTime;
    }

    public LocalDateTime getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(LocalDateTime finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Integer getReadingCount() {
        return readingCount;
    }

    public void setReadingCount(Integer readingCount) {
        this.readingCount = readingCount;
    }

    public Integer getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(Integer commitCount) {
        this.commitCount = commitCount;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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
        sb.append(", cancelReason=").append(cancelReason);
        sb.append(", serviceStatus=").append(serviceStatus);
        sb.append(", clientId=").append(clientId);
        sb.append(", servantId=").append(servantId);
        sb.append(", content=").append(content);
        sb.append(", serviceTime=").append(serviceTime);
        sb.append(", serviceDuration=").append(serviceDuration);
        sb.append(", phone=").append(phone);
        sb.append(", region=").append(region);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", detailedAddress=").append(detailedAddress);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", integral=").append(integral);
        sb.append(", tip=").append(tip);
        sb.append(", passTime=").append(passTime);
        sb.append(", finishedTime=").append(finishedTime);
        sb.append(", readingCount=").append(readingCount);
        sb.append(", commitCount=").append(commitCount);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}