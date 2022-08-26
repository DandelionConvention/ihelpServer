package com.services.products.ihelp.service.enums;

import com.google.common.base.Enums;
import com.services.products.ihelp.service.exception.BusinessExceptionCode;

/**
 * 文件用途
 */
public enum FileUseEnum
{
    /**
     * 测试
     */
    TEST(0, "test"),
    /**
     * 头像
     */
    AVATAR(1, "avatar"),
    ;

    public final Integer num;
    public final String path;

    FileUseEnum(Integer num, String path)
    {
        this.num = num;
        this.path = path;
    }

    public static FileUseEnum getEnumByName(String name)
    {
        return Enums.getIfPresent(FileUseEnum.class, name).toJavaUtil()
                .orElseThrow(BusinessExceptionCode.BAD_REQUEST::businessException);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("FileUseEnum{");
        sb.append("num=").append(num);
        sb.append(", path='").append(path).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
