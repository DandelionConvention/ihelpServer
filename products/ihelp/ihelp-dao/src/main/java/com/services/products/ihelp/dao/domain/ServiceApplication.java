package com.services.products.ihelp.dao.domain;

import java.time.LocalDateTime;

public class ServiceApplication {
    private Long serviceOrderId;

    private Long servantId;

    private Byte serviceStatus;

    private Byte cancelReason;

    private String remark;

    private String phone;

    private Integer region;

    private String province;

    private String city;

    private String county;

    private String detailedAddress;

    private String lng;

    private String lat;

    private Boolean isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(Long serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public Long getServantId() {
        return servantId;
    }

    public void setServantId(Long servantId) {
        this.servantId = servantId;
    }

    public Byte getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(Byte serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Byte getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(Byte cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        sb.append(", serviceOrderId=").append(serviceOrderId);
        sb.append(", servantId=").append(servantId);
        sb.append(", serviceStatus=").append(serviceStatus);
        sb.append(", cancelReason=").append(cancelReason);
        sb.append(", remark=").append(remark);
        sb.append(", phone=").append(phone);
        sb.append(", region=").append(region);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", detailedAddress=").append(detailedAddress);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}