package com.services.products.ihelp.dao.bo;

import java.math.BigDecimal;
import java.util.List;

public class HisServiceBO
{
    /**
     * id : 563511964567923205376
     * serviceStatus : aliqua ad ex eiusmod
     * content : pariatur
     * serviceTag : [{"id":12,"name":"elit Lorem velit ea"}]
     * integral : 21.9
     * address : {"province":"et","city":"cupidatat id ex commodo adipisicing"}
     * serviceTime : aliqua
     */

    private String id;
    private String serviceStatus;
    private String content;
    private BigDecimal integral;
    private ServiceAddressBO address;
    private String serviceTime;
    private List<ServiceTagBO> serviceTag;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getServiceStatus()
    {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus)
    {
        this.serviceStatus = serviceStatus;
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

    public ServiceAddressBO getAddress()
    {
        return address;
    }

    public void setAddress(ServiceAddressBO address)
    {
        this.address = address;
    }

    public String getServiceTime()
    {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime)
    {
        this.serviceTime = serviceTime;
    }

    public List<ServiceTagBO> getServiceTag()
    {
        return serviceTag;
    }

    public void setServiceTag(List<ServiceTagBO> serviceTag)
    {
        this.serviceTag = serviceTag;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("HisServiceBO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", serviceStatus='").append(serviceStatus).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", integral=").append(integral);
        sb.append(", address=").append(address);
        sb.append(", serviceTime='").append(serviceTime).append('\'');
        sb.append(", serviceTag=").append(serviceTag);
        sb.append('}');
        return sb.toString();
    }
}
