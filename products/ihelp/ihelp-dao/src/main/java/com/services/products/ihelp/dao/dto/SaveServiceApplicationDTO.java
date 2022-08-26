package com.services.products.ihelp.dao.dto;

public class SaveServiceApplicationDTO
{

    private String phone;
    private AddressBean address;
    private String description;

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public AddressBean getAddress()
    {
        return address;
    }

    public void setAddress(AddressBean address)
    {
        this.address = address;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public static class AddressBean
    {
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
        final StringBuilder sb = new StringBuilder("SaveServiceApplicationDTO{");
        sb.append("phone='").append(phone).append('\'');
        sb.append(", address=").append(address);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
