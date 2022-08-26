package com.services.products.ihelp.dao.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class SaveServiceOrderDTO
{

    /**
     * serviceTime : 1595209911
     * serviceDuration : 1
     * phone : 123456789
     * tags : [1,2]
     * integral : 100
     * content : 服务内容
     * address : {"province":"北京","city":"北京","county":"朝阳区","detail":"详细地址","lng":"114.13","lat":"90.77"}
     */

    private Long serviceTime;

    @Min(value = 1)
    @Max(value = 9)
    private Integer serviceDuration;

    private String phone;

    @DecimalMin(value = "0", message = "积分不能小于0")
    @Digits(integer = 8, fraction = 2, message = "积分不在有效范围内")
    private BigDecimal integral;
    private String content;
    @NotNull(message = "地址不能为空")
    private AddressBean address;

    private List<Integer> tags;

    public Long getServiceTime()
    {
        return serviceTime;
    }

    public void setServiceTime(Long serviceTime)
    {
        this.serviceTime = serviceTime;
    }

    public Integer getServiceDuration()
    {
        return serviceDuration;
    }

    public void setServiceDuration(Integer serviceDuration)
    {
        this.serviceDuration = serviceDuration;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public BigDecimal getIntegral()
    {
        return integral;
    }

    public void setIntegral(BigDecimal integral)
    {
        this.integral = integral;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public AddressBean getAddress()
    {
        return address;
    }

    public void setAddress(AddressBean address)
    {
        this.address = address;
    }

    public List<Integer> getTags()
    {
        return tags;
    }

    public void setTags(List<Integer> tags)
    {
        this.tags = tags;
    }

    public static class AddressBean
    {
        /**
         * province : 北京
         * city : 北京
         * county : 朝阳区
         * detail : 详细地址
         * lng : 114.13
         * lat : 90.77
         */

        private String province;
        private String city;
        private String county;
        private String detail;
        private String lng;
        private String lat;
        private Integer region;

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

        public String getCounty()
        {
            return county;
        }

        public void setCounty(String county)
        {
            this.county = county;
        }

        public String getDetail()
        {
            return detail;
        }

        public void setDetail(String detail)
        {
            this.detail = detail;
        }

        public String getLng()
        {
            return lng;
        }

        public void setLng(String lng)
        {
            this.lng = lng;
        }

        public String getLat()
        {
            return lat;
        }

        public void setLat(String lat)
        {
            this.lat = lat;
        }

        public Integer getRegion()
        {
            return region;
        }

        public void setRegion(Integer region)
        {
            this.region = region;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("AddressBean{");
            sb.append("province='").append(province).append('\'');
            sb.append(", city='").append(city).append('\'');
            sb.append(", county='").append(county).append('\'');
            sb.append(", detail='").append(detail).append('\'');
            sb.append(", lng='").append(lng).append('\'');
            sb.append(", lat='").append(lat).append('\'');
            sb.append(", region=").append(region);
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("SaveServiceOrderDTO{");
        sb.append("serviceTime=").append(serviceTime);
        sb.append(", serviceDuration=").append(serviceDuration);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", integral=").append(integral);
        sb.append(", content='").append(content).append('\'');
        sb.append(", address=").append(address);
        sb.append(", tags=").append(tags);
        sb.append('}');
        return sb.toString();
    }
}
