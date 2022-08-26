package com.services.products.ihelp.dao.bo;

public class ServiceAddressBO
{
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
        final StringBuilder sb = new StringBuilder("ServiceAddressBO{");
        sb.append("province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
