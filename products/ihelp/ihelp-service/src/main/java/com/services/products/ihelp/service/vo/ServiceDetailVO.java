package com.services.products.ihelp.service.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ServiceDetailVO
{
    /**
     * stats : {"readingCount":1,"commitCount":1}
     * detail : {"id":3482935364,"serviceTime":"2020-05-02 08:24","serviceDuration":1,"address":{"province":"广西壮族自治区","city":"海西蒙古族藏族自治州","county":"爱辉区","lng":"-1122993517659808.6","lat":"-5402741080620945"},"content":"毛青性例如开拉权然县厂马史带科。资增被保又场书集级示议酸党。身政元解养经设常类料必增前。时对值中角军并京入土直交积往山。机面车属往家全织能龙三认观。","serviceTag":[{"id":1,"name":"用成里争"},{"id":1,"name":"队采温问强"},{"id":1,"name":"克好头装"},{"id":1,"name":"美交计效离"}],"integral":2219298250}
     * userInfo : {"avatar":"http://dummyimage.com/400x400","nickname":"陆涛","creditLevel":4,"verified":true,"decade":90,"gender":0,"createTotal":8,"answerRate":2,"online":false,"recruiting":{"total":23,"list":[{"id":7.177221256053707E7,"content":"reprehenderit ullamco dolor","tags":[{"id":-5.818135341569426E7,"name":"non elit ullamco ipsum veniam"},{"id":-5.428075140210975E7,"name":"aute ea"},{"id":-2.0316662462197006E7,"name":"Except"},{"id":-1.5243975561479807E7,"name":"labore pariatur"}],"integral":8765},{"id":-2.3592349561023027E7,"content":"minim Ut aute in et","tags":[{"id":-8.493353793192582E7,"name":"elit sit"}],"integral":3234}]},"id":-4.991268551787158E7}
     * isCollected : true
     * comment : {"avatar":"http://dummyimage.com/120x240","nickname":"陈涛","role":"Excepteur dolore dolor","commentTime":1599984688,"commentLevel":1,"content":"料再七地才严红或自各做题比设将价王指。转出入场次和织王派并月京号真求越研团。想离报级党色精易然商来标亲干非听。月委叫心于几专二产指头圆产养史更。","images":["http://dummyimage.com/88x31","http://dummyimage.com/120x60"]}
     */

    private StatsBean stats;
    private DetailBean detail;
    private UserInfoBean userInfo;
    private Boolean isCollected;
    private CommentBean comment;

    public StatsBean getStats()
    {
        return stats;
    }

    public void setStats(StatsBean stats)
    {
        this.stats = stats;
    }

    public DetailBean getDetail()
    {
        return detail;
    }

    public void setDetail(DetailBean detail)
    {
        this.detail = detail;
    }

    public UserInfoBean getUserInfo()
    {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo)
    {
        this.userInfo = userInfo;
    }

    public Boolean isIsCollected()
    {
        return isCollected;
    }

    public void setIsCollected(Boolean isCollected)
    {
        this.isCollected = isCollected;
    }

    public CommentBean getComment()
    {
        return comment;
    }

    public void setComment(CommentBean comment)
    {
        this.comment = comment;
    }

    public static class StatsBean
    {
        /**
         * readingCount : 1
         * commitCount : 1
         */

        private Integer readingCount;
        private Integer commitCount;

        public Integer getReadingCount()
        {
            return readingCount;
        }

        public void setReadingCount(Integer readingCount)
        {
            this.readingCount = readingCount;
        }

        public Integer getCommitCount()
        {
            return commitCount;
        }

        public void setCommitCount(Integer commitCount)
        {
            this.commitCount = commitCount;
        }
    }

    public static class DetailBean
    {
        /**
         * id : 3482935364
         * serviceTime : 2020-05-02 08:24
         * serviceDuration : 1
         * address : {"province":"广西壮族自治区","city":"海西蒙古族藏族自治州","county":"爱辉区","lng":"-1122993517659808.6","lat":"-5402741080620945"}
         * content : 毛青性例如开拉权然县厂马史带科。资增被保又场书集级示议酸党。身政元解养经设常类料必增前。时对值中角军并京入土直交积往山。机面车属往家全织能龙三认观。
         * serviceTag : [{"id":1,"name":"用成里争"},{"id":1,"name":"队采温问强"},{"id":1,"name":"克好头装"},{"id":1,"name":"美交计效离"}]
         * integral : 2219298250
         */

        private Long id;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime serviceTime;
        private Byte serviceDuration;
        private AddressBean address;
        private String content;
        private BigDecimal integral;
        private List<ServiceTagBean> serviceTag;

        public Long getId()
        {
            return id;
        }

        public void setId(Long id)
        {
            this.id = id;
        }

        public LocalDateTime getServiceTime()
        {
            return serviceTime;
        }

        public void setServiceTime(LocalDateTime serviceTime)
        {
            this.serviceTime = serviceTime;
        }

        public Byte getServiceDuration()
        {
            return serviceDuration;
        }

        public void setServiceDuration(Byte serviceDuration)
        {
            this.serviceDuration = serviceDuration;
        }

        public AddressBean getAddress()
        {
            return address;
        }

        public void setAddress(AddressBean address)
        {
            this.address = address;
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

        public List<ServiceTagBean> getServiceTag()
        {
            return serviceTag;
        }

        public void setServiceTag(List<ServiceTagBean> serviceTag)
        {
            this.serviceTag = serviceTag;
        }

        public static class AddressBean
        {
            /**
             * province : 广西壮族自治区
             * city : 海西蒙古族藏族自治州
             * county : 爱辉区
             * lng : -1122993517659808.6
             * lat : -5402741080620945
             */

            private String province;
            private String city;
            private String county;
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
        }

        public static class ServiceTagBean
        {
            /**
             * id : 1
             * name : 用成里争
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
        }
    }

    public static class UserInfoBean
    {
        /**
         * avatar : http://dummyimage.com/400x400
         * nickname : 陆涛
         * creditLevel : 4
         * verified : true
         * decade : 90
         * gender : 0
         * createTotal : 8
         * answerRate : 2
         * online : false
         * recruiting : {"total":23,"list":[{"id":7.177221256053707E7,"content":"reprehenderit ullamco dolor","tags":[{"id":-5.818135341569426E7,"name":"non elit ullamco ipsum veniam"},{"id":-5.428075140210975E7,"name":"aute ea"},{"id":-2.0316662462197006E7,"name":"Except"},{"id":-1.5243975561479807E7,"name":"labore pariatur"}],"integral":8765},{"id":-2.3592349561023027E7,"content":"minim Ut aute in et","tags":[{"id":-8.493353793192582E7,"name":"elit sit"}],"integral":3234}]}
         * id : -4.991268551787158E7
         */

        private String avatar;
        private String nickname;
        private Integer creditLevel;
        private Boolean verified;
        private Integer decade;
        private String gender;
        private Integer createTotal;
        private Integer answerRate;
        private Boolean online;
        private RecruitingBean recruiting;
        private Long id;

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

        public Integer getCreditLevel()
        {
            return creditLevel;
        }

        public void setCreditLevel(Integer creditLevel)
        {
            this.creditLevel = creditLevel;
        }

        public Boolean isVerified()
        {
            return verified;
        }

        public void setVerified(Boolean verified)
        {
            this.verified = verified;
        }

        public Integer getDecade()
        {
            return decade;
        }

        public void setDecade(Integer decade)
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

        public Integer getCreateTotal()
        {
            return createTotal;
        }

        public void setCreateTotal(Integer createTotal)
        {
            this.createTotal = createTotal;
        }

        public Integer getAnswerRate()
        {
            return answerRate;
        }

        public void setAnswerRate(Integer answerRate)
        {
            this.answerRate = answerRate;
        }

        public Boolean isOnline()
        {
            return online;
        }

        public void setOnline(Boolean online)
        {
            this.online = online;
        }

        public RecruitingBean getRecruiting()
        {
            return recruiting;
        }

        public void setRecruiting(RecruitingBean recruiting)
        {
            this.recruiting = recruiting;
        }

        public Long getId()
        {
            return id;
        }

        public void setId(Long id)
        {
            this.id = id;
        }

        public static class RecruitingBean
        {
            /**
             * total : 23
             * list : [{"id":7.177221256053707E7,"content":"reprehenderit ullamco dolor","tags":[{"id":-5.818135341569426E7,"name":"non elit ullamco ipsum veniam"},{"id":-5.428075140210975E7,"name":"aute ea"},{"id":-2.0316662462197006E7,"name":"Except"},{"id":-1.5243975561479807E7,"name":"labore pariatur"}],"integral":8765},{"id":-2.3592349561023027E7,"content":"minim Ut aute in et","tags":[{"id":-8.493353793192582E7,"name":"elit sit"}],"integral":3234}]
             */

            private Integer total;
            private List<ListBean> list;

            public Integer getTotal()
            {
                return total;
            }

            public void setTotal(Integer total)
            {
                this.total = total;
            }

            public List<ListBean> getList()
            {
                return list;
            }

            public void setList(List<ListBean> list)
            {
                this.list = list;
            }

            public static class ListBean
            {
                /**
                 * id : 7.177221256053707E7
                 * content : reprehenderit ullamco dolor
                 * tags : [{"id":-5.818135341569426E7,"name":"non elit ullamco ipsum veniam"},{"id":-5.428075140210975E7,"name":"aute ea"},{"id":-2.0316662462197006E7,"name":"Except"},{"id":-1.5243975561479807E7,"name":"labore pariatur"}]
                 * integral : 8765
                 */

                private Long id;
                private String content;
                private BigDecimal integral;
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

                public List<TagsBean> getTags()
                {
                    return tags;
                }

                public void setTags(List<TagsBean> tags)
                {
                    this.tags = tags;
                }

                public static class TagsBean
                {
                    /**
                     * id : -5.818135341569426E7
                     * name : non elit ullamco ipsum veniam
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
                }
            }
        }
    }

    public static class CommentBean
    {
        /**
         * avatar : http://dummyimage.com/120x240
         * nickname : 陈涛
         * role : Excepteur dolore dolor
         * commentTime : 1599984688
         * commentLevel : 1
         * content : 料再七地才严红或自各做题比设将价王指。转出入场次和织王派并月京号真求越研团。想离报级党色精易然商来标亲干非听。月委叫心于几专二产指头圆产养史更。
         * images : ["http://dummyimage.com/88x31","http://dummyimage.com/120x60"]
         */

        private String avatar;
        private String nickname;
        private String role;
        private Integer commentTime; // 时间戳
        private Integer commentLevel;
        private String content;
        private List<String> images;

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

        public String getRole()
        {
            return role;
        }

        public void setRole(String role)
        {
            this.role = role;
        }

        public Integer getCommentTime()
        {
            return commentTime;
        }

        public void setCommentTime(Integer commentTime)
        {
            this.commentTime = commentTime;
        }

        public Integer getCommentLevel()
        {
            return commentLevel;
        }

        public void setCommentLevel(Integer commentLevel)
        {
            this.commentLevel = commentLevel;
        }

        public String getContent()
        {
            return content;
        }

        public void setContent(String content)
        {
            this.content = content;
        }

        public List<String> getImages()
        {
            return images;
        }

        public void setImages(List<String> images)
        {
            this.images = images;
        }
    }
}
