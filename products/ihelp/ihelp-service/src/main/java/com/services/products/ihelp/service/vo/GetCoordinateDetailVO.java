package com.services.products.ihelp.service.vo;

import com.services.core.bo.tencent.lbs.CoordinateDetailResponseBO;

public class GetCoordinateDetailVO
{
    private Double lat;
    private Double lng;
    private String province;
    private String city;
    private String county;
    private String detail;
    private String region;

    public GetCoordinateDetailVO copy(CoordinateDetailResponseBO coordinateDetailResponseBO)
    {
        CoordinateDetailResponseBO.ResultBean resultBean = coordinateDetailResponseBO.getResult();
        CoordinateDetailResponseBO.ResultBean.AddressComponentBean addressComponentBean =
                resultBean.getAddress_component();
        CoordinateDetailResponseBO.ResultBean.LocationBean locationBean = resultBean.getLocation();
        CoordinateDetailResponseBO.ResultBean.AdInfoBean adInfoBean = resultBean.getAd_info();
        province = addressComponentBean.getProvince();
        city = addressComponentBean.getCity();
        county = addressComponentBean.getDistrict();
        detail = addressComponentBean.getStreet();
        lat = locationBean.getLat();
        lng = locationBean.getLng();
        region = adInfoBean.getAdcode();
        return this;
    }

    public Double getLat()
    {
        return lat;
    }

    public void setLat(Double lat)
    {
        this.lat = lat;
    }

    public Double getLng()
    {
        return lng;
    }

    public void setLng(Double lng)
    {
        this.lng = lng;
    }

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

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GetCoordinateDetailVO{");
        sb.append("lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", county='").append(county).append('\'');
        sb.append(", detail='").append(detail).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
