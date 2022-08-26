package com.services.products.ihelp.service.vo;

import java.math.BigDecimal;

public class GetMyInfoVO
{
    private Long id;
    private Boolean verified;
    private String avatar;
    private String nickname;
    private String role;
    private BigDecimal integral;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Boolean getVerified()
    {
        return verified;
    }

    public void setVerified(Boolean verified)
    {
        this.verified = verified;
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

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public BigDecimal getIntegral()
    {
        return integral;
    }

    public void setIntegral(BigDecimal integral)
    {
        this.integral = integral;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GetMyInfoVO{");
        sb.append("id=").append(id);
        sb.append(", verified=").append(verified);
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", integral=").append(integral);
        sb.append('}');
        return sb.toString();
    }
}
