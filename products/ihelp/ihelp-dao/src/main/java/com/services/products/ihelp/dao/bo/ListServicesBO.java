package com.services.products.ihelp.dao.bo;

import java.math.BigDecimal;
import java.util.List;

public class ListServicesBO
{
    private Long id;
    private String content;
    private BigDecimal integral;
    private String lastSeen;
    private ServiceAddressBO region;
    private List<ServiceTagBO> tags;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public BigDecimal getIntegral()
    {
        return integral;
    }

    public void setIntegral(BigDecimal integral)
    {
        this.integral = integral;
    }

    public String getLastSeen()
    {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen)
    {
        this.lastSeen = lastSeen;
    }

    public ServiceAddressBO getRegion()
    {
        return region;
    }

    public void setRegion(ServiceAddressBO region)
    {
        this.region = region;
    }

    public List<ServiceTagBO> getTags()
    {
        return tags;
    }

    public void setTags(List<ServiceTagBO> tags)
    {
        this.tags = tags;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ServiceBO{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", integral=").append(integral);
        sb.append(", lastSeen='").append(lastSeen).append('\'');
        sb.append(", region=").append(region);
        sb.append(", tags=").append(tags);
        sb.append('}');
        return sb.toString();
    }
}
