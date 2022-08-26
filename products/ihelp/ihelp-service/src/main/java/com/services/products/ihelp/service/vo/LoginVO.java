package com.services.products.ihelp.service.vo;

import java.math.BigDecimal;

public class LoginVO
{
    /**
     * id : 3474609187
     * verified : true
     * avatar : http://dummyimage.com/468x60
     * nickname : 蒋涛
     * role : 老人
     * collection : 2743563898
     * integral : -7.708850998669416E7
     * footprint : 2143402052
     * session : user:1000000000:d9e272cb-4e6f-4ee9-a2b7-623207390b46
     */

    private Long id;
    private Boolean verified;
    private String avatar;
    private String nickname;
    private String role;
    private Integer collection;
    private BigDecimal integral;
    private Integer footprint;
    private String session;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Boolean isVerified()
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

    public Integer getCollection()
    {
        return collection;
    }

    public void setCollection(Integer collection)
    {
        this.collection = collection;
    }

    public BigDecimal getIntegral()
    {
        return integral;
    }

    public void setIntegral(BigDecimal integral)
    {
        this.integral = integral;
    }

    public Integer getFootprint()
    {
        return footprint;
    }

    public void setFootprint(Integer footprint)
    {
        this.footprint = footprint;
    }

    public String getSession()
    {
        return session;
    }

    public void setSession(String session)
    {
        this.session = session;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("LoginVO{");
        sb.append("id=").append(id);
        sb.append(", verified=").append(verified);
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", collection=").append(collection);
        sb.append(", integral=").append(integral);
        sb.append(", footprint=").append(footprint);
        sb.append(", session='").append(session).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
