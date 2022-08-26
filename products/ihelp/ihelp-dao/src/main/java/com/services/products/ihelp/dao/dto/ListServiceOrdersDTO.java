package com.services.products.ihelp.dao.dto;

import java.math.BigDecimal;

public class ListServiceOrdersDTO extends PageDTO
{
    /**
     * page : 1
     * per_page : 20
     * complex : true
     * service_time : asc
     * commit_count : asc
     * nearby : true
     * latest : true
     * credit : true
     * create_time : 1
     * min_integral : 0
     * max_integral : 100
     * min_age : 60
     * max_age : 100
     * service_tag : [1,2]
     * min_duration : 1
     * max_duration : 2
     * region : 100000
     */

    private Boolean complex;
    private String serviceTime;
    private String commitCount;
    private Boolean nearby;
    private Boolean latest;
    private Boolean credit;
    private Integer createTime;
    private BigDecimal minIntegral;
    private BigDecimal maxIntegral;
    private Integer minAge;
    private Integer maxAge;
    private Integer minDuration;
    private Integer maxDuration;
    private String region;
    private String serviceTag;


    public Boolean isComplex()
    {
        return complex;
    }

    public void setComplex(Boolean complex)
    {
        this.complex = complex;
    }

    public String getServiceTime()
    {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime)
    {
        this.serviceTime = serviceTime;
    }

    public String getCommitCount()
    {
        return commitCount;
    }

    public void setCommitCount(String commitCount)
    {
        this.commitCount = commitCount;
    }

    public Boolean isNearby()
    {
        return nearby;
    }

    public void setNearby(Boolean nearby)
    {
        this.nearby = nearby;
    }

    public Boolean isLatest()
    {
        return latest;
    }

    public void setLatest(Boolean latest)
    {
        this.latest = latest;
    }

    public Boolean isCredit()
    {
        return credit;
    }

    public void setCredit(Boolean credit)
    {
        this.credit = credit;
    }

    public Integer getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Integer createTime)
    {
        this.createTime = createTime;
    }

    public BigDecimal getMinIntegral()
    {
        return minIntegral;
    }

    public void setMinIntegral(BigDecimal minIntegral)
    {
        this.minIntegral = minIntegral;
    }

    public BigDecimal getMaxIntegral()
    {
        return maxIntegral;
    }

    public void setMaxIntegral(BigDecimal maxIntegral)
    {
        this.maxIntegral = maxIntegral;
    }

    public Integer getMinAge()
    {
        return minAge;
    }

    public void setMinAge(Integer minAge)
    {
        this.minAge = minAge;
    }

    public Integer getMaxAge()
    {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge)
    {
        this.maxAge = maxAge;
    }

    public Integer getMinDuration()
    {
        return minDuration;
    }

    public void setMinDuration(Integer minDuration)
    {
        this.minDuration = minDuration;
    }

    public Integer getMaxDuration()
    {
        return maxDuration;
    }

    public void setMaxDuration(Integer maxDuration)
    {
        this.maxDuration = maxDuration;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getServiceTag()
    {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag)
    {
        this.serviceTag = serviceTag;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ListServiceOrdersDTO{");
        sb.append("complex=").append(complex);
        sb.append(", serviceTime='").append(serviceTime).append('\'');
        sb.append(", commitCount='").append(commitCount).append('\'');
        sb.append(", nearby=").append(nearby);
        sb.append(", latest=").append(latest);
        sb.append(", credit=").append(credit);
        sb.append(", createTime=").append(createTime);
        sb.append(", minIntegral=").append(minIntegral);
        sb.append(", maxIntegral=").append(maxIntegral);
        sb.append(", minAge=").append(minAge);
        sb.append(", maxAge=").append(maxAge);
        sb.append(", minDuration=").append(minDuration);
        sb.append(", maxDuration=").append(maxDuration);
        sb.append(", region='").append(region).append('\'');
        sb.append(", serviceTag='").append(serviceTag).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
