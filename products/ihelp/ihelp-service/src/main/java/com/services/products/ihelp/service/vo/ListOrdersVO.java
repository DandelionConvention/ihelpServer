package com.services.products.ihelp.service.vo;

import com.services.products.ihelp.dao.dto.PageDTO;

import java.math.BigDecimal;

public class ListOrdersVO extends PageDTO
{
    public static class ListOrdersDto {

        /**
         * id : 8939
         * content : 服务内容服务内容务内容服务内容服务内容帮忙浇花务内容帮忙浇花
         * state : CREATED
         * integral : 3451
         * commitCount : 102
         * user : {"avatar":"https://dummyimage.com/50x50","nickname":"欧阳大妈"}
         */

        private Long id;
        private String content;
        private String state;
        private BigDecimal integral;
        private int commitCount;
        private UserBean user;

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

        public String getState()
        {
            return state;
        }

        public void setState(String state)
        {
            this.state = state;
        }

        public BigDecimal getIntegral()
        {
            return integral;
        }

        public void setIntegral(BigDecimal integral)
        {
            this.integral = integral;
        }

        public int getCommitCount()
        {
            return commitCount;
        }

        public void setCommitCount(int commitCount)
        {
            this.commitCount = commitCount;
        }

        public UserBean getUser()
        {
            return user;
        }

        public void setUser(UserBean user)
        {
            this.user = user;
        }

        public static class UserBean
        {
            /**
             * avatar : https://dummyimage.com/50x50
             * nickname : 欧阳大妈
             */

            private String avatar;
            private String nickname;

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

            @Override
            public String toString()
            {
                final StringBuilder sb = new StringBuilder("UserBean{");
                sb.append("avatar='").append(avatar).append('\'');
                sb.append(", nickname='").append(nickname).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("ListOrdersDto{");
            sb.append("id=").append(id);
            sb.append(", content='").append(content).append('\'');
            sb.append(", state='").append(state).append('\'');
            sb.append(", integral=").append(integral);
            sb.append(", commitCount=").append(commitCount);
            sb.append(", user=").append(user);
            sb.append('}');
            return sb.toString();
        }
    }
}
