package com.services.core.bo.tencent.cloud;

import com.alibaba.fastjson.annotation.JSONField;

public class IDCardOcrRequestBO
{
    /**
     * 图片的 Base64 值。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
     图片的 ImageUrl、ImageBase64 必须提供一个，如果都提供，只使用 ImageUrl。
     */
    @JSONField(name = "ImageBase64")
    private String imageBase64;

    /**
     * 图片的 Url 地址。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
     建议图片存储于腾讯云，可保障更高的下载速度和稳定性。
     */
    @JSONField(name = "ImageUrl")
    private String imageUrl;

    /**
     * FRONT：身份证有照片的一面（人像面），
     BACK：身份证有国徽的一面（国徽面），
     该参数如果不填，将为您自动判断身份证正反面。
     */
    @JSONField(name = "CardSide")
    private String cardSide;

    /**
     * 以下可选字段均为bool 类型，默认false：
     CropIdCard，身份证照片裁剪（去掉证件外多余的边缘、自动矫正拍摄角度）
     CropPortrait，人像照片裁剪（自动抠取身份证头像区域）
     CopyWarn，复印件告警
     BorderCheckWarn，边框和框内遮挡告警
     ReshootWarn，翻拍告警
     DetectPsWarn，PS检测告警
     TempIdWarn，临时身份证告警
     InvalidDateWarn，身份证有效日期不合法告警
     Quality，图片质量分数（评价图片的模糊程度）
     MultiCardDetect，是否开启多卡证检测

     SDK 设置方式参考：
     Config = Json.stringify({"CropIdCard":true,"CropPortrait":true})
     API 3.0 Explorer 设置方式参考：
     Config = {"CropIdCard":true,"CropPortrait":true}
     */
    @JSONField(name = "Config")
    private String config;

    public static class ConfigBean
    {
        /**
         * 身份证照片裁剪（去掉证件外多余的边缘、自动矫正拍摄角度）
         */
        @JSONField(name = "CropIdCard")
        private Boolean cropIdCard;
        /**
         * 人像照片裁剪（自动抠取身份证头像区域）
         */
        @JSONField(name = "CropPortrait")
        private Boolean cropPortrait;
        /**
         * 复印件告警
         */
        @JSONField(name = "CopyWarn")
        private Boolean copyWarn;
        /**
         * 边框和框内遮挡告警
         */
        @JSONField(name = "BorderCheckWarn")
        private Boolean borderCheckWarn;
        /**
         * 翻拍告警
         */
        @JSONField(name = "ReshootWarn")
        private Boolean reshootWarn;
        /**
         * PS检测告警
         */
        @JSONField(name = "DetectPsWarn")
        private Boolean detectPsWarn;
        /**
         * 临时身份证告警
         */
        @JSONField(name = "TempIdWarn")
        private Boolean tempIdWarn;
        /**
         * 身份证有效日期不合法告警
         */
        @JSONField(name = "InvalidDateWarn")
        private Boolean invalidDateWarnf;
        /**
         * 图片质量分数（评价图片的模糊程度）
         */
        @JSONField(name = "Quality")
        private Boolean quality;
        /**
         * 是否开启多卡证检测
         */
        @JSONField(name = "MultiCardDetect")
        private Boolean multiCardDetect;
        /**
         * 是否开启反光检测
         */
        @JSONField(name = "ReflectWarn")
        private Boolean reflectWarn;

        public Boolean getCropIdCard()
        {
            return cropIdCard;
        }

        public void setCropIdCard(Boolean cropIdCard)
        {
            this.cropIdCard = cropIdCard;
        }

        public Boolean getCropPortrait()
        {
            return cropPortrait;
        }

        public void setCropPortrait(Boolean cropPortrait)
        {
            this.cropPortrait = cropPortrait;
        }

        public Boolean getCopyWarn()
        {
            return copyWarn;
        }

        public void setCopyWarn(Boolean copyWarn)
        {
            this.copyWarn = copyWarn;
        }

        public Boolean getBorderCheckWarn()
        {
            return borderCheckWarn;
        }

        public void setBorderCheckWarn(Boolean borderCheckWarn)
        {
            this.borderCheckWarn = borderCheckWarn;
        }

        public Boolean getReshootWarn()
        {
            return reshootWarn;
        }

        public void setReshootWarn(Boolean reshootWarn)
        {
            this.reshootWarn = reshootWarn;
        }

        public Boolean getDetectPsWarn()
        {
            return detectPsWarn;
        }

        public void setDetectPsWarn(Boolean detectPsWarn)
        {
            this.detectPsWarn = detectPsWarn;
        }

        public Boolean getTempIdWarn()
        {
            return tempIdWarn;
        }

        public void setTempIdWarn(Boolean tempIdWarn)
        {
            this.tempIdWarn = tempIdWarn;
        }

        public Boolean getInvalidDateWarnf()
        {
            return invalidDateWarnf;
        }

        public void setInvalidDateWarnf(Boolean invalidDateWarnf)
        {
            this.invalidDateWarnf = invalidDateWarnf;
        }

        public Boolean getQuality()
        {
            return quality;
        }

        public void setQuality(Boolean quality)
        {
            this.quality = quality;
        }

        public Boolean getMultiCardDetect()
        {
            return multiCardDetect;
        }

        public void setMultiCardDetect(Boolean multiCardDetect)
        {
            this.multiCardDetect = multiCardDetect;
        }

        public Boolean getReflectWarn()
        {
            return reflectWarn;
        }

        public void setReflectWarn(Boolean reflectWarn)
        {
            this.reflectWarn = reflectWarn;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("ConfigBean{");
            sb.append("cropIdCard=").append(cropIdCard);
            sb.append(", cropPortrait=").append(cropPortrait);
            sb.append(", copyWarn=").append(copyWarn);
            sb.append(", borderCheckWarn=").append(borderCheckWarn);
            sb.append(", reshootWarn=").append(reshootWarn);
            sb.append(", detectPsWarn=").append(detectPsWarn);
            sb.append(", tempIdWarn=").append(tempIdWarn);
            sb.append(", invalidDateWarnf=").append(invalidDateWarnf);
            sb.append(", quality=").append(quality);
            sb.append(", multiCardDetect=").append(multiCardDetect);
            sb.append(", reflectWarn=").append(reflectWarn);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * Get 图片的 Base64 值。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
     图片的 ImageUrl、ImageBase64 必须提供一个，如果都提供，只使用 ImageUrl。
     * @return ImageBase64 图片的 Base64 值。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
    图片的 ImageUrl、ImageBase64 必须提供一个，如果都提供，只使用 ImageUrl。
     */
    public String getImageBase64() {
        return this.imageBase64;
    }

    /**
     * Set 图片的 Base64 值。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
     图片的 ImageUrl、ImageBase64 必须提供一个，如果都提供，只使用 ImageUrl。
     * @param imageBase64 图片的 Base64 值。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
    图片的 ImageUrl、ImageBase64 必须提供一个，如果都提供，只使用 ImageUrl。
     */
    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    /**
     * Get 图片的 Url 地址。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
     建议图片存储于腾讯云，可保障更高的下载速度和稳定性。
     * @return ImageUrl 图片的 Url 地址。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
    建议图片存储于腾讯云，可保障更高的下载速度和稳定性。
     */
    public String getImageUrl() {
        return this.imageUrl;
    }

    /**
     * Set 图片的 Url 地址。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
     建议图片存储于腾讯云，可保障更高的下载速度和稳定性。
     * @param imageUrl 图片的 Url 地址。要求图片经Base64编码后不超过 7M，分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。建议卡片部分占据图片2/3以上。
    建议图片存储于腾讯云，可保障更高的下载速度和稳定性。
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Get FRONT：身份证有照片的一面（人像面），
     BACK：身份证有国徽的一面（国徽面），
     该参数如果不填，将为您自动判断身份证正反面。
     * @return CardSide FRONT：身份证有照片的一面（人像面），
    BACK：身份证有国徽的一面（国徽面），
    该参数如果不填，将为您自动判断身份证正反面。
     */
    public String getCardSide() {
        return this.cardSide;
    }

    /**
     * Set FRONT：身份证有照片的一面（人像面），
     BACK：身份证有国徽的一面（国徽面），
     该参数如果不填，将为您自动判断身份证正反面。
     * @param cardSide FRONT：身份证有照片的一面（人像面），
    BACK：身份证有国徽的一面（国徽面），
    该参数如果不填，将为您自动判断身份证正反面。
     */
    public void setCardSide(String cardSide) {
        this.cardSide = cardSide;
    }

    /**
     * Get 以下可选字段均为bool 类型，默认false：
     CropIdCard，身份证照片裁剪（去掉证件外多余的边缘、自动矫正拍摄角度）
     CropPortrait，人像照片裁剪（自动抠取身份证头像区域）
     CopyWarn，复印件告警
     BorderCheckWarn，边框和框内遮挡告警
     ReshootWarn，翻拍告警
     DetectPsWarn，PS检测告警
     TempIdWarn，临时身份证告警
     InvalidDateWarn，身份证有效日期不合法告警
     Quality，图片质量分数（评价图片的模糊程度）
     MultiCardDetect，是否开启多卡证检测

     SDK 设置方式参考：
     Config = Json.stringify({"CropIdCard":true,"CropPortrait":true})
     API 3.0 Explorer 设置方式参考：
     Config = {"CropIdCard":true,"CropPortrait":true}
     * @return Config 以下可选字段均为bool 类型，默认false：
    CropIdCard，身份证照片裁剪（去掉证件外多余的边缘、自动矫正拍摄角度）
    CropPortrait，人像照片裁剪（自动抠取身份证头像区域）
    CopyWarn，复印件告警
    BorderCheckWarn，边框和框内遮挡告警
    ReshootWarn，翻拍告警
    DetectPsWarn，PS检测告警
    TempIdWarn，临时身份证告警
    InvalidDateWarn，身份证有效日期不合法告警
    Quality，图片质量分数（评价图片的模糊程度）
    MultiCardDetect，是否开启多卡证检测

    SDK 设置方式参考：
    Config = Json.stringify({"CropIdCard":true,"CropPortrait":true})
    API 3.0 Explorer 设置方式参考：
    Config = {"CropIdCard":true,"CropPortrait":true}
     */
    public String getConfig() {
        return this.config;
    }

    /**
     * Set 以下可选字段均为bool 类型，默认false：
     CropIdCard，身份证照片裁剪（去掉证件外多余的边缘、自动矫正拍摄角度）
     CropPortrait，人像照片裁剪（自动抠取身份证头像区域）
     CopyWarn，复印件告警
     BorderCheckWarn，边框和框内遮挡告警
     ReshootWarn，翻拍告警
     DetectPsWarn，PS检测告警
     TempIdWarn，临时身份证告警
     InvalidDateWarn，身份证有效日期不合法告警
     Quality，图片质量分数（评价图片的模糊程度）
     MultiCardDetect，是否开启多卡证检测

     SDK 设置方式参考：
     Config = Json.stringify({"CropIdCard":true,"CropPortrait":true})
     API 3.0 Explorer 设置方式参考：
     Config = {"CropIdCard":true,"CropPortrait":true}
     * @param config 以下可选字段均为bool 类型，默认false：
    CropIdCard，身份证照片裁剪（去掉证件外多余的边缘、自动矫正拍摄角度）
    CropPortrait，人像照片裁剪（自动抠取身份证头像区域）
    CopyWarn，复印件告警
    BorderCheckWarn，边框和框内遮挡告警
    ReshootWarn，翻拍告警
    DetectPsWarn，PS检测告警
    TempIdWarn，临时身份证告警
    InvalidDateWarn，身份证有效日期不合法告警
    Quality，图片质量分数（评价图片的模糊程度）
    MultiCardDetect，是否开启多卡证检测

    SDK 设置方式参考：
    Config = Json.stringify({"CropIdCard":true,"CropPortrait":true})
    API 3.0 Explorer 设置方式参考：
    Config = {"CropIdCard":true,"CropPortrait":true}
     */
    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("IDCardOcrRequestBO{");
        sb.append("imageBase64='").append(imageBase64).append('\'');
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", cardSide='").append(cardSide).append('\'');
        sb.append(", config='").append(config).append('\'');
        sb.append('}');
        return sb.toString();
    }
}