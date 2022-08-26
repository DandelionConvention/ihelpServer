package com.services.core.bo.tencent.cloud;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class IDCardOcrResponseBO
{

    /**
     * 姓名（人像面）
     */
    private String Name;

    /**
     * 性别（人像面）
     */
    private String Sex;

    /**
     * 民族（人像面）
     */
    private String Nation;

    /**
     * 出生日期（人像面）
     */
    private String Birth;

    /**
     * 地址（人像面）
     */
    private String Address;

    /**
     * 身份证号（人像面）
     */
    private String IdNum;

    /**
     * 发证机关（国徽面）
     */
    private String Authority;

    /**
     * 证件有效期（国徽面）
     */
    private String ValidDate;

    /**
     * 扩展信息，不请求则不返回，具体输入参考示例3和示例4。
     IdCard，裁剪后身份证照片的base64编码，请求 Config.CropIdCard 时返回；
     Portrait，身份证头像照片的base64编码，请求 Config.CropPortrait 时返回；

     Quality，图片质量分数，请求 Config.Quality 时返回（取值范围：0~100，分数越低越模糊，建议阈值≥50）;
     BorderCodeValue，身份证边框不完整告警阈值分数，请求 Config.BorderCheckWarn时返回（取值范围：0~100，分数越低边框遮挡可能性越低，建议阈值≥50）;

     WarnInfos，告警信息，Code 告警码列表和释义：
     -9100	身份证有效日期不合法告警，
     -9101	身份证边框不完整告警，
     -9102	身份证复印件告警，
     -9103	身份证翻拍告警，
     -9105	身份证框内遮挡告警，
     -9104	临时身份证告警，
     -9106	身份证 PS 告警。
     */
    private String AdvancedInfo;

    /**
     * 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    private String RequestId;

    public AdvanceInfoBean advancedInfoBean() {
        return JSON.parseObject(this.AdvancedInfo, AdvanceInfoBean.class);
    }

    /**
     * Get 姓名（人像面）
     * @return Name 姓名（人像面）
     */
    public String getName() {
        return this.Name;
    }

    /**
     * Set 姓名（人像面）
     * @param Name 姓名（人像面）
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Get 性别（人像面）
     * @return Sex 性别（人像面）
     */
    public String getSex() {
        return this.Sex;
    }

    /**
     * Set 性别（人像面）
     * @param Sex 性别（人像面）
     */
    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    /**
     * Get 民族（人像面）
     * @return Nation 民族（人像面）
     */
    public String getNation() {
        return this.Nation;
    }

    /**
     * Set 民族（人像面）
     * @param Nation 民族（人像面）
     */
    public void setNation(String Nation) {
        this.Nation = Nation;
    }

    /**
     * Get 出生日期（人像面）
     * @return Birth 出生日期（人像面）
     */
    public String getBirth() {
        return this.Birth;
    }

    /**
     * Set 出生日期（人像面）
     * @param Birth 出生日期（人像面）
     */
    public void setBirth(String Birth) {
        this.Birth = Birth;
    }

    /**
     * Get 地址（人像面）
     * @return Address 地址（人像面）
     */
    public String getAddress() {
        return this.Address;
    }

    /**
     * Set 地址（人像面）
     * @param Address 地址（人像面）
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * Get 身份证号（人像面）
     * @return IdNum 身份证号（人像面）
     */
    public String getIdNum() {
        return this.IdNum;
    }

    /**
     * Set 身份证号（人像面）
     * @param IdNum 身份证号（人像面）
     */
    public void setIdNum(String IdNum) {
        this.IdNum = IdNum;
    }

    /**
     * Get 发证机关（国徽面）
     * @return Authority 发证机关（国徽面）
     */
    public String getAuthority() {
        return this.Authority;
    }

    /**
     * Set 发证机关（国徽面）
     * @param Authority 发证机关（国徽面）
     */
    public void setAuthority(String Authority) {
        this.Authority = Authority;
    }

    /**
     * Get 证件有效期（国徽面）
     * @return ValidDate 证件有效期（国徽面）
     */
    public String getValidDate() {
        return this.ValidDate;
    }

    /**
     * Set 证件有效期（国徽面）
     * @param ValidDate 证件有效期（国徽面）
     */
    public void setValidDate(String ValidDate) {
        this.ValidDate = ValidDate;
    }

    /**
     * Get 扩展信息，不请求则不返回，具体输入参考示例3和示例4。
     IdCard，裁剪后身份证照片的base64编码，请求 Config.CropIdCard 时返回；
     Portrait，身份证头像照片的base64编码，请求 Config.CropPortrait 时返回；

     Quality，图片质量分数，请求 Config.Quality 时返回（取值范围：0~100，分数越低越模糊，建议阈值≥50）;
     BorderCodeValue，身份证边框不完整告警阈值分数，请求 Config.BorderCheckWarn时返回（取值范围：0~100，分数越低边框遮挡可能性越低，建议阈值≥50）;

     WarnInfos，告警信息，Code 告警码列表和释义：
     -9100	身份证有效日期不合法告警，
     -9101	身份证边框不完整告警，
     -9102	身份证复印件告警，
     -9103	身份证翻拍告警，
     -9105	身份证框内遮挡告警，
     -9104	临时身份证告警，
     -9106	身份证 PS 告警。
     * @return AdvancedInfo 扩展信息，不请求则不返回，具体输入参考示例3和示例4。
    IdCard，裁剪后身份证照片的base64编码，请求 Config.CropIdCard 时返回；
    Portrait，身份证头像照片的base64编码，请求 Config.CropPortrait 时返回；

    Quality，图片质量分数，请求 Config.Quality 时返回（取值范围：0~100，分数越低越模糊，建议阈值≥50）;
    BorderCodeValue，身份证边框不完整告警阈值分数，请求 Config.BorderCheckWarn时返回（取值范围：0~100，分数越低边框遮挡可能性越低，建议阈值≥50）;

    WarnInfos，告警信息，Code 告警码列表和释义：
    -9100	身份证有效日期不合法告警，
    -9101	身份证边框不完整告警，
    -9102	身份证复印件告警，
    -9103	身份证翻拍告警，
    -9105	身份证框内遮挡告警，
    -9104	临时身份证告警，
    -9106	身份证 PS 告警。
     */
    public String getAdvancedInfo()
    {
        return AdvancedInfo;
    }

    /**
     * Set 扩展信息，不请求则不返回，具体输入参考示例3和示例4。
     IdCard，裁剪后身份证照片的base64编码，请求 Config.CropIdCard 时返回；
     Portrait，身份证头像照片的base64编码，请求 Config.CropPortrait 时返回；

     Quality，图片质量分数，请求 Config.Quality 时返回（取值范围：0~100，分数越低越模糊，建议阈值≥50）;
     BorderCodeValue，身份证边框不完整告警阈值分数，请求 Config.BorderCheckWarn时返回（取值范围：0~100，分数越低边框遮挡可能性越低，建议阈值≥50）;

     WarnInfos，告警信息，Code 告警码列表和释义：
     -9100	身份证有效日期不合法告警，
     -9101	身份证边框不完整告警，
     -9102	身份证复印件告警，
     -9103	身份证翻拍告警，
     -9105	身份证框内遮挡告警，
     -9104	临时身份证告警，
     -9106	身份证 PS 告警。
     * @param AdvancedInfo 扩展信息，不请求则不返回，具体输入参考示例3和示例4。
    IdCard，裁剪后身份证照片的base64编码，请求 Config.CropIdCard 时返回；
    Portrait，身份证头像照片的base64编码，请求 Config.CropPortrait 时返回；

    Quality，图片质量分数，请求 Config.Quality 时返回（取值范围：0~100，分数越低越模糊，建议阈值≥50）;
    BorderCodeValue，身份证边框不完整告警阈值分数，请求 Config.BorderCheckWarn时返回（取值范围：0~100，分数越低边框遮挡可能性越低，建议阈值≥50）;

    WarnInfos，告警信息，Code 告警码列表和释义：
    -9100	身份证有效日期不合法告警，
    -9101	身份证边框不完整告警，
    -9102	身份证复印件告警，
    -9103	身份证翻拍告警，
    -9105	身份证框内遮挡告警，
    -9104	临时身份证告警，
    -9106	身份证 PS 告警。
     */
    public void setAdvancedInfo(String AdvancedInfo) {
        this.AdvancedInfo = AdvancedInfo;
    }

    /**
     * Get 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     * @return RequestId 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    public String getRequestId() {
        return this.RequestId;
    }

    /**
     * Set 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     * @param RequestId 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    public void setRequestId(String RequestId) {
        this.RequestId = RequestId;
    }

    public static class AdvanceInfoBean
    {

        /**
         * IdCard :
         * Portrait :
         * WarnInfos : [-9102]
         * Quality : 97
         * BorderCodeValue : 27
         */

        private String IdCard;
        private String Portrait;
        private Integer Quality;
        private Integer BorderCodeValue;
        private List<Integer> WarnInfos;

        public String getIdCard()
        {
            return IdCard;
        }

        public void setIdCard(String IdCard)
        {
            this.IdCard = IdCard;
        }

        public String getPortrait()
        {
            return Portrait;
        }

        public void setPortrait(String Portrait)
        {
            this.Portrait = Portrait;
        }

        public Integer getQuality()
        {
            return Quality;
        }

        public void setQuality(Integer Quality)
        {
            this.Quality = Quality;
        }

        public Integer getBorderCodeValue()
        {
            return BorderCodeValue;
        }

        public void setBorderCodeValue(Integer BorderCodeValue)
        {
            this.BorderCodeValue = BorderCodeValue;
        }

        public List<Integer> getWarnInfos()
        {
            return WarnInfos;
        }

        public void setWarnInfos(List<Integer> WarnInfos)
        {
            this.WarnInfos = WarnInfos;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("AdvanceInfoBean{");
            sb.append("IdCard='").append(IdCard).append('\'');
            sb.append(", Portrait='").append(Portrait).append('\'');
            sb.append(", Quality=").append(Quality);
            sb.append(", BorderCodeValue=").append(BorderCodeValue);
            sb.append(", WarnInfos=").append(WarnInfos);
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("IDCardOcrResponseBO{");
        sb.append("Name='").append(Name).append('\'');
        sb.append(", Sex='").append(Sex).append('\'');
        sb.append(", Nation='").append(Nation).append('\'');
        sb.append(", Birth='").append(Birth).append('\'');
        sb.append(", Address='").append(Address).append('\'');
        sb.append(", IdNum='").append(IdNum).append('\'');
        sb.append(", Authority='").append(Authority).append('\'');
        sb.append(", ValidDate='").append(ValidDate).append('\'');
        sb.append(", AdvancedInfo='").append(AdvancedInfo).append('\'');
        sb.append(", RequestId='").append(RequestId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
