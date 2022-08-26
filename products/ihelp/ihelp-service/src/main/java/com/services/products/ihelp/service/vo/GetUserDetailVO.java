package com.services.products.ihelp.service.vo;

import com.services.products.ihelp.dao.bo.HisServiceBO;

import java.util.List;

public class GetUserDetailVO
{
    /**
     * role : 
     * avatar : deserunt
     * nickname : proident mollit cillum
     * id : 23456789045789
     * online : true
     * verified : true
     * creditLevel : 
     * signature : ullamco dolor
     * stats : {"serviceTotal":45678,"commitTotal":234567,"answerRate":345678,"createTotal":3456,"recruitingTotal":34567}
     * perPage : 1
     * page : 8
     * hasMore : true
     * services : [{"id":123456789012345678,"serviceStatus":"nulla laborum enim","content":"sint incididunt velit","serviceTag":[{"id":1,"name":"dolor Excepteur anim tempor"},{"id":2,"name":"sunt"},{"id":3,"name":"nostrud aliquip voluptate"},{"id":4,"name":"eiusmod reprehenderit"}],"integral":1.0670633123601288E7,"address":{"province":"non id aliquip sit","city":"in Ut commodo Excepteur"},"serviceTime":"aliqua"}]
     */

    private String role;
    private String avatar;
    private String nickname;
    private Long id;
    private Boolean online;
    private Boolean verified;
    private String creditLevel;
    private String signature;
    private StatsBean stats;
    private Integer perPage;
    private Integer page;
    private Boolean hasMore;
    private List<HisServiceBO> services;

    public static class StatsBean
    {
        /**
         * serviceTotal : 45678
         * commitTotal : 234567
         * answerRate : 345678
         * createTotal : 3456
         * recruitingTotal : 34567
         */

        private Integer serviceTotal;
        private Integer commitTotal;
        private Integer answerRate;
        private Integer createTotal;
        private Integer recruitingTotal;

        public Integer getServiceTotal()
        {
            return serviceTotal;
        }

        public void setServiceTotal(Integer serviceTotal)
        {
            this.serviceTotal = serviceTotal;
        }

        public Integer getCommitTotal()
        {
            return commitTotal;
        }

        public void setCommitTotal(Integer commitTotal)
        {
            this.commitTotal = commitTotal;
        }

        public Integer getAnswerRate()
        {
            return answerRate;
        }

        public void setAnswerRate(Integer answerRate)
        {
            this.answerRate = answerRate;
        }

        public Integer getCreateTotal()
        {
            return createTotal;
        }

        public void setCreateTotal(Integer createTotal)
        {
            this.createTotal = createTotal;
        }

        public Integer getRecruitingTotal()
        {
            return recruitingTotal;
        }

        public void setRecruitingTotal(Integer recruitingTotal)
        {
            this.recruitingTotal = recruitingTotal;
        }
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Boolean getOnline()
    {
        return online;
    }

    public void setOnline(Boolean online)
    {
        this.online = online;
    }

    public Boolean getVerified()
    {
        return verified;
    }

    public void setVerified(Boolean verified)
    {
        this.verified = verified;
    }

    public String getCreditLevel()
    {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel)
    {
        this.creditLevel = creditLevel;
    }

    public String getSignature()
    {
        return signature;
    }

    public void setSignature(String signature)
    {
        this.signature = signature;
    }

    public StatsBean getStats()
    {
        return stats;
    }

    public void setStats(StatsBean stats)
    {
        this.stats = stats;
    }

    public Integer getPerPage()
    {
        return perPage;
    }

    public void setPerPage(Integer perPage)
    {
        this.perPage = perPage;
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Boolean getHasMore()
    {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore)
    {
        this.hasMore = hasMore;
    }

    public List<HisServiceBO> getServices()
    {
        return services;
    }

    public void setServices(List<HisServiceBO> services)
    {
        this.services = services;
    }
}
