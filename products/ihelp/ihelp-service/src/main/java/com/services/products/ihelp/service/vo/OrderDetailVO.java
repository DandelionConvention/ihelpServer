package com.services.products.ihelp.service.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDetailVO
{

    /**
     * service : {"id":-64754455,"createTime":"2020-09-21 20:45:24","commitTime":"2010-09-01 20:20:21","state":"FINISHED","content":"服务内容嘎嘎的复古大翻领的反馈饭撒放水淀粉撒风发似懂非懂","tags":[{"id":-64074994,"name":"拖地"},{"id":-56894373,"name":"维修"},{"id":26047272,"name":"洗衣服"},{"id":96159749,"name":"清洁"},{"id":-47621720,"name":"做饭"}],"integral":-54771978,"region":{"province":"广东","city":"佛山"}}
     * cancelReason : {"reason":"Ut labore reprehenderit culpa Excepteur","integral":-8.308907988800134E7,"description":"cupidatat","images":["deserunt aliquip minim","culpa "]}
     * servant : {"nickname":"活力阿金","phone":"13542342342","description":"会飞的更好风光好风光好风光还好风光会飞的更好"}
     * client : {"nickname":"赵四阿姨","phone":"18865436453","address":{"province":"上海","city":"南宁","county":"","detail":"六道镇巴能村12巷4号","lng":"enim elit eiusmod minim in","lat":"ex dolore commodo aliquip amet"}}
     */

    private ServiceBean service;
    private CancelReasonBean cancelReason;
    private ServantBean servant;
    private ClientBean client;

    public ServiceBean getService()
    {
        return service;
    }

    public void setService(ServiceBean service)
    {
        this.service = service;
    }

    public CancelReasonBean getCancelReason()
    {
        return cancelReason;
    }

    public void setCancelReason(CancelReasonBean cancelReason)
    {
        this.cancelReason = cancelReason;
    }

    public ServantBean getServant()
    {
        return servant;
    }

    public void setServant(ServantBean servant)
    {
        this.servant = servant;
    }

    public ClientBean getClient()
    {
        return client;
    }

    public void setClient(ClientBean client)
    {
        this.client = client;
    }

    public static class ServiceBean
    {
        /**
         * id : -64754455
         * createTime : 2020-09-21 20:45:24
         * commitTime : 2010-09-01 20:20:21
         * state : FINISHED
         * content : 服务内容嘎嘎的复古大翻领的反馈饭撒放水淀粉撒风发似懂非懂
         * tags : [{"id":-64074994,"name":"拖地"},{"id":-56894373,"name":"维修"},{"id":26047272,"name":"洗衣服"},{"id":96159749,"name":"清洁"},{"id":-47621720,"name":"做饭"}]
         * integral : -54771978
         * region : {"province":"广东","city":"佛山"}
         */

        private Long id;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createTime;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime commitTime;
        private String state;
        private String content;
        private BigDecimal integral;
        private RegionBean region;
        private List<TagsBean> tags;

        public Long getId()
        {
            return id;
        }

        public void setId(Long id)
        {
            this.id = id;
        }

        public LocalDateTime getCreateTime()
        {
            return createTime;
        }

        public void setCreateTime(LocalDateTime createTime)
        {
            this.createTime = createTime;
        }

        public LocalDateTime getCommitTime()
        {
            return commitTime;
        }

        public void setCommitTime(LocalDateTime commitTime)
        {
            this.commitTime = commitTime;
        }

        public String getState()
        {
            return state;
        }

        public void setState(String state)
        {
            this.state = state;
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
             * city : 佛山
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
             * id : -64074994
             * name : 拖地
             */

            private Integer id;
            private String name;

            public Integer getId()
            {
                return id;
            }

            public void setId(Integer id)
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
            final StringBuilder sb = new StringBuilder("ServiceBean{");
            sb.append("id=").append(id);
            sb.append(", createTime='").append(createTime).append('\'');
            sb.append(", commitTime='").append(commitTime).append('\'');
            sb.append(", state='").append(state).append('\'');
            sb.append(", content='").append(content).append('\'');
            sb.append(", integral=").append(integral);
            sb.append(", region=").append(region);
            sb.append(", tags=").append(tags);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class CancelReasonBean
    {
        /**
         * reason : Ut labore reprehenderit culpa Excepteur
         * integral : -8.308907988800134E7
         * description : cupidatat
         * images : ["deserunt aliquip minim","culpa "]
         */

        private String reason;
        private BigDecimal integral;
        private String description;
        private List<String> images;

        public String getReason()
        {
            return reason;
        }

        public void setReason(String reason)
        {
            this.reason = reason;
        }

        public BigDecimal getIntegral()
        {
            return integral;
        }

        public void setIntegral(BigDecimal integral)
        {
            this.integral = integral;
        }

        public String getDescription()
        {
            return description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        public List<String> getImages()
        {
            return images;
        }

        public void setImages(List<String> images)
        {
            this.images = images;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("CancelReasonBean{");
            sb.append("reason='").append(reason).append('\'');
            sb.append(", integral=").append(integral);
            sb.append(", description='").append(description).append('\'');
            sb.append(", images=").append(images);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class ServantBean
    {
        /**
         * nickname : 活力阿金
         * phone : 13542342342
         * description : 会飞的更好风光好风光好风光还好风光会飞的更好
         */

        private String nickname;
        private String phone;
        private String description;

        public String getNickname()
        {
            return nickname;
        }

        public void setNickname(String nickname)
        {
            this.nickname = nickname;
        }

        public String getPhone()
        {
            return phone;
        }

        public void setPhone(String phone)
        {
            this.phone = phone;
        }

        public String getDescription()
        {
            return description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("ServantBean{");
            sb.append("nickname='").append(nickname).append('\'');
            sb.append(", phone='").append(phone).append('\'');
            sb.append(", description='").append(description).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class ClientBean
    {
        /**
         * nickname : 赵四阿姨
         * phone : 18865436453
         * address : {"province":"上海","city":"南宁","county":"","detail":"六道镇巴能村12巷4号","lng":"enim elit eiusmod minim in","lat":"ex dolore commodo aliquip amet"}
         */

        private String nickname;
        private String phone;
        private AddressBean address;

        public String getNickname()
        {
            return nickname;
        }

        public void setNickname(String nickname)
        {
            this.nickname = nickname;
        }

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

        public static class AddressBean
        {
            /**
             * province : 上海
             * city : 南宁
             * county :
             * detail : 六道镇巴能村12巷4号
             * lng : enim elit eiusmod minim in
             * lat : ex dolore commodo aliquip amet
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
            final StringBuilder sb = new StringBuilder("ClientBean{");
            sb.append("nickname='").append(nickname).append('\'');
            sb.append(", phone='").append(phone).append('\'');
            sb.append(", address=").append(address);
            sb.append('}');
            return sb.toString();
        }
    }
}
