package com.services.products.ihelp.service.vo;

import com.services.products.ihelp.dao.dto.PageDTO;

public class ListServiceOrderServantsVO extends PageDTO
{
    public static class ServiceOrderServantsDto
    {
        private Long id;
        private String avatar;
        private String nickname;
        private String creditLevel;
        private Integer decade;
        private String gender;
        private Boolean online;

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

        public Boolean isOnline()
        {
            return online;
        }

        public void setOnline(Boolean online)
        {
            this.online = online;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("ServiceOrderServantsDto{");
            sb.append("id=").append(id);
            sb.append(", avatar='").append(avatar).append('\'');
            sb.append(", nickname='").append(nickname).append('\'');
            sb.append(", creditLevel='").append(creditLevel).append('\'');
            sb.append(", decade=").append(decade);
            sb.append(", gender='").append(gender).append('\'');
            sb.append(", online=").append(online);
            sb.append('}');
            return sb.toString();
        }
    }
}
