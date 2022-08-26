package com.services.products.ihelp.service.vo;

import java.math.BigDecimal;
import java.util.List;

public class ListAllServiceOrdersVO
{
    private Long id;
    private String content;
    private BigDecimal integral;
    private RegionBean region;
    private String lastSeen;
    private List<TagsBean> tags;

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

    public RegionBean getRegion()
    {
        return region;
    }

    public void setRegion(RegionBean region)
    {
        this.region = region;
    }

    public String getLastSeen()
    {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen)
    {
        this.lastSeen = lastSeen;
    }

    public List<TagsBean> getTags()
    {
        return tags;
    }

    public void setTags(List<TagsBean> tags)
    {
        this.tags = tags;
    }

    public static class RegionBean
    {
        /**
         * province : 广东
         * city : 南宁
         */

        private String province;
        private String city;

        public String getProvince()
        {
            return province;
        }

        public void setProvince(String province)
        {
            this.province = province;
        }

        public String getCity()
        {
            return city;
        }

        public void setCity(String city)
        {
            this.city = city;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("RegionBean{");
            sb.append("province='").append(province).append('\'');
            sb.append(", city='").append(city).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class TagsBean
    {
        /**
         * id : 74496642
         * name : 洗澡
         */

        private BigDecimal id;
        private String name;

        public BigDecimal getId()
        {
            return id;
        }

        public void setId(BigDecimal id)
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("TagsBean{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ListAllServiceOrdersVO{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", integral=").append(integral);
        sb.append(", region=").append(region);
        sb.append(", lastSeen='").append(lastSeen).append('\'');
        sb.append(", tags=").append(tags);
        sb.append('}');
        return sb.toString();
    }
}
