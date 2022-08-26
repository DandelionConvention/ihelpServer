package com.services.products.ihelp.service.vo;

public class GetApplicationDetailVO
{
    /**
     * id : 3456789045667788924
     * avatar : http://dummyimage.com/120x90
     * nickname : mollit aute ex Duis commodo
     * creditLevel : tempor amet pariatur culpa
     * decade : 90
     * gender :
     * online : false
     * remark : reprehenderit dolor
     * address : {"province":"consequat","city":"nisi amet cupidatat quis veniam","county":"magna adipisicing","detail":"et anim","lng":"sunt tempor laboris nisi","lat":"Ut do non"}
     */

    private Long id;
    private String avatar;
    private String nickname;
    private String creditLevel;
    private String decade;
    private String gender;
    private Boolean online;
    private String remark;
    private AddressBean address;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getCreditLevel()
    {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel)
    {
        this.creditLevel = creditLevel;
    }

    public String getDecade()
    {
        return decade;
    }

    public void setDecade(String decade)
    {
        this.decade = decade;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Boolean isOnline()
    {
        return online;
    }

    public void setOnline(Boolean online)
    {
        this.online = online;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public AddressBean getAddress()
    {
        return address;
    }

    public void setAddress(AddressBean address)
    {
        this.address = address;
    }

    public static class AddressBean
    {
        /**
         * province : consequat
         * city : nisi amet cupidatat quis veniam
         * county : magna adipisicing
         * detail : et anim
         * lng : sunt tempor laboris nisi
         * lat : Ut do non
         */

        private String province;
        private String city;
        private String county;
        private String detail;
        private String lng;
        private String lat;

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
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GetApplicationDetailVO{");
        sb.append("id=").append(id);
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", creditLevel='").append(creditLevel).append('\'');
        sb.append(", decade=").append(decade);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", online=").append(online);
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
