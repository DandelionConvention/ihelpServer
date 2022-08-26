package com.services.core.bo.weixin.miniapp;

public class GetUserInfoResponseBO
{
    private String openId;
    private String nickName;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
    private Watermark watermark;

    public String getOpenId()
    {
        return openId;
    }

    public void setOpenId(String openId)
    {
        this.openId = openId;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl)
    {
        this.avatarUrl = avatarUrl;
    }

    public String getUnionId()
    {
        return unionId;
    }

    public void setUnionId(String unionId)
    {
        this.unionId = unionId;
    }

    public Watermark getWatermark()
    {
        return watermark;
    }

    public void setWatermark(Watermark watermark)
    {
        this.watermark = watermark;
    }

    public static class Watermark
    {
        private String timestamp;
        private String appid;

        public String getTimestamp()
        {
            return timestamp;
        }

        public void setTimestamp(String timestamp)
        {
            this.timestamp = timestamp;
        }

        public String getAppid()
        {
            return appid;
        }

        public void setAppid(String appid)
        {
            this.appid = appid;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("Watermark{");
            sb.append("timestamp='").append(timestamp).append('\'');
            sb.append(", appid='").append(appid).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GetUserInfoResponseBO{");
        sb.append("openId='").append(openId).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", avatarUrl='").append(avatarUrl).append('\'');
        sb.append(", unionId='").append(unionId).append('\'');
        sb.append(", watermark=").append(watermark);
        sb.append('}');
        return sb.toString();
    }
}
