package com.services.core.bo.tencent.lbs;

public class AddressDetailResponseBO
{
    /**
     * status : 0
     * message : query ok
     * result : {"title":"海淀西大街74号","location":{"lng":116.307015,"lat":39.982915},"ad_info":{"adcode":"110108"},"address_components":{"province":"北京市","city":"北京市","district":"海淀区","street":"海淀西大街","street_number":"74"},"similarity":0.8,"deviation":1000,"reliability":7,"level":9}
     */

    private Integer status;
    private String message;
    private ResultBean result;

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public ResultBean getResult()
    {
        return result;
    }

    public void setResult(ResultBean result)
    {
        this.result = result;
    }

    public static class ResultBean
    {
        /**
         * title : 海淀西大街74号
         * location : {"lng":116.307015,"lat":39.982915}
         * ad_info : {"adcode":"110108"}
         * address_components : {"province":"北京市","city":"北京市","district":"海淀区","street":"海淀西大街","street_number":"74"}
         * similarity : 0.8
         * deviation : 1000
         * reliability : 7
         * level : 9
         */

        private String title;
        private LocationBean location;
        private AdInfoBean ad_info;
        private AddressComponentsBean address_components;
        private Double similarity;
        private Integer deviation;
        private Integer reliability;
        private Integer level;

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public LocationBean getLocation()
        {
            return location;
        }

        public void setLocation(LocationBean location)
        {
            this.location = location;
        }

        public AdInfoBean getAd_info()
        {
            return ad_info;
        }

        public void setAd_info(AdInfoBean ad_info)
        {
            this.ad_info = ad_info;
        }

        public AddressComponentsBean getAddress_components()
        {
            return address_components;
        }

        public void setAddress_components(AddressComponentsBean address_components)
        {
            this.address_components = address_components;
        }

        public Double getSimilarity()
        {
            return similarity;
        }

        public void setSimilarity(Double similarity)
        {
            this.similarity = similarity;
        }

        public Integer getDeviation()
        {
            return deviation;
        }

        public void setDeviation(Integer deviation)
        {
            this.deviation = deviation;
        }

        public Integer getReliability()
        {
            return reliability;
        }

        public void setReliability(Integer reliability)
        {
            this.reliability = reliability;
        }

        public Integer getLevel()
        {
            return level;
        }

        public void setLevel(Integer level)
        {
            this.level = level;
        }

        public static class LocationBean
        {
            /**
             * lng : 116.307015
             * lat : 39.982915
             */

            private Double lng;
            private Double lat;

            public Double getLng()
            {
                return lng;
            }

            public void setLng(Double lng)
            {
                this.lng = lng;
            }

            public Double getLat()
            {
                return lat;
            }

            public void setLat(Double lat)
            {
                this.lat = lat;
            }

            @Override
            public String toString()
            {
                final StringBuilder sb = new StringBuilder("LocationBean{");
                sb.append("lng=").append(lng);
                sb.append(", lat=").append(lat);
                sb.append('}');
                return sb.toString();
            }
        }

        public static class AdInfoBean
        {
            /**
             * adcode : 110108
             */

            private String adcode;

            public String getAdcode()
            {
                return adcode;
            }

            public void setAdcode(String adcode)
            {
                this.adcode = adcode;
            }

            @Override
            public String toString()
            {
                final StringBuilder sb = new StringBuilder("AdInfoBean{");
                sb.append("adcode='").append(adcode).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

        public static class AddressComponentsBean
        {
            /**
             * province : 北京市
             * city : 北京市
             * district : 海淀区
             * street : 海淀西大街
             * street_number : 74
             */

            private String province;
            private String city;
            private String district;
            private String street;
            private String street_number;

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

            public String getDistrict()
            {
                return district;
            }

            public void setDistrict(String district)
            {
                this.district = district;
            }

            public String getStreet()
            {
                return street;
            }

            public void setStreet(String street)
            {
                this.street = street;
            }

            public String getStreet_number()
            {
                return street_number;
            }

            public void setStreet_number(String street_number)
            {
                this.street_number = street_number;
            }

            @Override
            public String toString()
            {
                final StringBuilder sb = new StringBuilder("AddressComponentsBean{");
                sb.append("province='").append(province).append('\'');
                sb.append(", city='").append(city).append('\'');
                sb.append(", district='").append(district).append('\'');
                sb.append(", street='").append(street).append('\'');
                sb.append(", street_number='").append(street_number).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("ResultBean{");
            sb.append("title='").append(title).append('\'');
            sb.append(", location=").append(location);
            sb.append(", ad_info=").append(ad_info);
            sb.append(", address_components=").append(address_components);
            sb.append(", similarity=").append(similarity);
            sb.append(", deviation=").append(deviation);
            sb.append(", reliability=").append(reliability);
            sb.append(", level=").append(level);
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AddressDetailResponseBO{");
        sb.append("status=").append(status);
        sb.append(", message='").append(message).append('\'');
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }
}
